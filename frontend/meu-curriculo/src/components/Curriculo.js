import React, { useState } from 'react';
import { FaGithub, FaLinkedin } from 'react-icons/fa';

function Curriculo() {
  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [formacao, setFormacao] = useState('');
  const [subFormacao, setSubFormacao] = useState('');
  const [experiencia, setExperiencia] = useState({
    empresa: '',
    cargo: '',
    anoInicio: '',
    anoTermino: ''
  });
  const [cep, setCep] = useState("");
  const [logradouro, setLogradouro] = useState("");
  const [bairro, setBairro] = useState("");
  const [cidade, setCidade] = useState("");
  const [estado, setEstado] = useState("");

  const [informacoesAdicionais, setInformacoesAdicionais] = useState({
    github: '',
    linkedin: '',
    sobre: ''
  });

  const handleFormacaoChange = (e) => {
    setFormacao(e.target.value);
    setSubFormacao('');
  };

  const handleExperienciaChange = (e) => {
    const { name, value } = e.target;
    setExperiencia((prev) => ({
      ...prev,
      [name]: value
    }));
  };

  const handleInformacoesAdicionaisChange = (e) => {
    const { name, value } = e.target;
    setInformacoesAdicionais((prev) => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`
      Currículo enviado:
      Nome: ${nome}
      E-mail: ${email}
      Formação: ${formacao} - ${subFormacao}
      Experiência Profissional:
        Empresa: ${experiencia.empresa}, Cargo: ${experiencia.cargo}, Início: ${experiencia.anoInicio}, Término: ${experiencia.anoTermino}
      Endereço:
        CEP: ${cep}, Logradouro: ${logradouro}, Bairro: ${bairro}, Cidade: ${cidade}, Estado: ${estado}
      GitHub: ${informacoesAdicionais.github}
      LinkedIn: ${informacoesAdicionais.linkedin}
      Sobre: ${informacoesAdicionais.sobre}
    `);
  };

  return (
    <div id="curriculo" className="curriculo-container">
      <h2>Cadastro de Currículo</h2>
      <form onSubmit={handleSubmit}>

        <div className="input-group">
          <label>Nome Completo:</label>
          <input
            type="text"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            required
            placeholder="Digite seu nome completo"
          />
        </div>

        <div className="input-group">
          <label>E-mail:</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            placeholder="Digite seu e-mail"
          />
        </div>

        <div className="input-group">
          <label>CEP:</label>
          <input
            type="text"
            value={cep}
            onChange={(e) => setCep(e.target.value)}
            maxLength="8"
            placeholder="Digite seu CEP"
          />
        </div>

        <div className="input-group">
          <label>Logradouro:</label>
          <input
            type="text"
            value={logradouro}
            onChange={(e) => setLogradouro(e.target.value)}
            placeholder="Digite seu logradouro"
          />
        </div>

        <div className="input-group">
          <label>Bairro:</label>
          <input
            type="text"
            value={bairro}
            onChange={(e) => setBairro(e.target.value)}
            placeholder="Digite seu bairro"
          />
        </div>

        <div className="input-group">
          <label>Cidade:</label>
          <input
            type="text"
            value={cidade}
            onChange={(e) => setCidade(e.target.value)}
            placeholder="Digite sua cidade"
          />
        </div>

        <div className="input-group">
          <label>Estado:</label>
          <input
            type="text"
            value={estado}
            onChange={(e) => setEstado(e.target.value)}
            placeholder="Digite seu estado"
          />
        </div>

        <div className="input-group">
          <label>Formação:</label>
          <select
            value={formacao}
            onChange={handleFormacaoChange}
            required
          >
            <option value="">Selecione sua formação</option>
            <option value="Graduação">Graduação</option>
            <option value="Pós-Graduação">Pós-Graduação</option>
            <option value="Técnico">Técnico</option>
          </select>
        </div>

        {formacao === "Graduação" && (
          <div className="input-group">
            <label>Tipo de Graduação:</label>
            <select
              value={subFormacao}
              onChange={(e) => setSubFormacao(e.target.value)}
              required
            >
              <option value="">Selecione o tipo</option>
              <option value="Bacharelado">Bacharelado</option>
              <option value="Licenciatura">Licenciatura</option>
              <option value="Tecnólogo">Tecnólogo</option>
            </select>
          </div>
        )}

        {formacao === "Pós-Graduação" && (
          <div className="input-group">
            <label>Tipo de Pós-Graduação:</label>
            <input
              type="text"
              value={subFormacao}
              onChange={(e) => setSubFormacao(e.target.value)}
              placeholder="Digite o tipo de pós-graduação (MBA, Mestrado, Doutorado, etc.)"
              required
            />
          </div>
        )}

        <div className="input-group">
          <label>Nome da Empresa:</label>
          <input
            type="text"
            name="empresa"
            value={experiencia.empresa}
            onChange={handleExperienciaChange}
            required
            placeholder="Digite o nome da empresa"
          />
        </div>

        <div className="input-group">
          <label>Cargo:</label>
          <input
            type="text"
            name="cargo"
            value={experiencia.cargo}
            onChange={handleExperienciaChange}
            required
            placeholder="Digite o cargo"
          />
        </div>

        <div className="input-group">
          <label>Ano de Início:</label>
          <select
            name="anoInicio"
            value={experiencia.anoInicio}
            onChange={handleExperienciaChange}
            required
          >
            <option value="">Selecione o ano de início</option>
            {Array.from({ length: 50 }, (_, i) => 2024 - i).map((ano) => (
              <option key={ano} value={ano}>
                {ano}
              </option>
            ))}
          </select>
        </div>

        <div className="input-group">
          <label>Ano de Término:</label>
          <select
            name="anoTermino"
            value={experiencia.anoTermino}
            onChange={handleExperienciaChange}
            required
          >
            <option value="">Selecione o ano de término</option>
            {Array.from({ length: 50 }, (_, i) => 2024 - i).map((ano) => (
              <option key={ano} value={ano}>
                {ano}
              </option>
            ))}
          </select>
        </div>

        <div className="input-group">
          <label>GitHub:</label>
          <div className="input-with-icon">
            <FaGithub />
            <input
              type="url"
              name="github"
              value={informacoesAdicionais.github}
              onChange={handleInformacoesAdicionaisChange}
              placeholder="Digite seu link do GitHub"
            />
          </div>
        </div>

        <div className="input-group">
          <label>LinkedIn:</label>
          <div className="input-with-icon">
            <FaLinkedin />
            <input
              type="url"
              name="linkedin"
              value={informacoesAdicionais.linkedin}
              onChange={handleInformacoesAdicionaisChange}
              placeholder="Digite seu link do LinkedIn"
            />
          </div>
        </div>

       

        <button type="submit">Enviar Currículo</button>
      </form>
    </div>
  );
}

export default Curriculo;
