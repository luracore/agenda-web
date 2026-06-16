import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

import ContatoList from './components/ContatoList';
import ContatoForm from './components/ContatoForm';

import AtendimentoList from './components/AtendimentoList';
import AtendimentoForm from './components/AtendimentoForm';

import ExameList from './components/ExameList';
import ExameForm from './components/ExameForm';

import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <nav className="navbar">
          <h1>📅 Agenda Web</h1>

          <div className="nav-links">
            <Link to="/contatos">Contatos</Link>
            <Link to="/atendimentos">Atendimentos</Link>
            <Link to="/exames">Exames</Link>
          </div>
        </nav>

        <main className="container">
          <Routes>
            {/* Página inicial */}
            <Route path="/" element={<ContatoList />} />

            {/* Contatos */}
            <Route path="/contatos" element={<ContatoList />} />
            <Route path="/contatos/novo" element={<ContatoForm />} />
            <Route path="/contatos/editar/:id" element={<ContatoForm />} />

            {/* Atendimentos */}
            <Route path="/atendimentos" element={<AtendimentoList />} />
            <Route path="/atendimentos/novo" element={<AtendimentoForm />} />
            <Route path="/atendimentos/editar/:id" element={<AtendimentoForm />} />

            {/* Exames */}
            <Route path="/exames" element={<ExameList />} />
            <Route path="/exames/novo" element={<ExameForm />} />
            <Route path="/exames/editar/:id" element={<ExameForm />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;
