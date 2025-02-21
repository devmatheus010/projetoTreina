import React from "react";
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image'; // Importando o componente Image
import { FaUser } from 'react-icons/fa'; // Exemplo de ícone para colocar na imagem

function MyNavbar() {
  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href="#home">Curriculo</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#home">Cadastrar currículo</Nav.Link>
            <Nav.Link href="#link">Exibir currículo</Nav.Link>
          </Nav>
          {/* Imagem com aumento de tamanho */}
          <div style={{ position: 'relative' }}>
            <Image
              src="https://via.placeholder.com/100" // Aumentando a imagem
              roundedCircle
              style={{ width: '80px', height: '80px' }} // Definindo o tamanho desejado
            />
            {/* Ícone sobre a imagem com cor mais visível */}
            <div style={{
              position: 'absolute',
              top: '50%',
              left: '50%',
              transform: 'translate(-50%, -50%)',
              color: '#007bff', // Alterando a cor do ícone para um tom de azul
              fontSize: '24px', // Aumentando o tamanho do ícone
            }}>
              <FaUser />
            </div>
          </div>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default MyNavbar;
