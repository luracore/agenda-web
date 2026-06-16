import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { exameService } from '../services/api';

function ExameList() {
  const [exames, setExames] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    carregarExames();
  }, []);

  const carregarExames = async () => {
    try {
      const response = await exameService.listar();
      setExames(response.data);
    } catch (error) {
      console.error('Erro ao carregar exames:', error);
    } finally {
      setLoading(false);
    }
  };

  const deletarExame = async (id) => {
    if (window.confirm('Tem certeza que deseja excluir este exame?')) {
      try {
        await exameService.deletar(id);
        carregarExames();
      } catch (error) {
        console.error('Erro ao deletar exame:', error);
      }
    }
  };

  if (loading) return <p>Carregando...</p>;

  return (
    <div>
      <div className="header">
        <h2>🧪 Exames</h2>

        <Link to="/exames/novo" className="btn btn-primary">
          + Novo Exame
        </Link>
      </div>

      <table className="table">
        <thead>
          <tr>
            <th>Descrição</th>
            <th>Link</th>
            <th>Posologia</th>
            <th>Ações</th>
          </tr>
        </thead>

        <tbody>
          {exames.map(ex => (
            <tr key={ex.id}>
              <td>{ex.descricao || '-'}</td>
              <td>{ex.link || '-'}</td>
              <td>{ex.posologia || '-'}</td>
              <td>
                <Link
                  to={`/exames/editar/${ex.id}`}
                  className="btn btn-sm"
                >
                  Editar
                </Link>

                <button
                  onClick={() => deletarExame(ex.id)}
                  className="btn btn-danger btn-sm"
                >
                  Excluir
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {exames.length === 0 && (
        <p className="empty">Nenhum exame cadastrado.</p>
      )}
    </div>
  );
}

export default ExameList;
