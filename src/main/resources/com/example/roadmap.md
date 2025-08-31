# 📦 Sistema de Controle de Estoque

Este projeto tem como objetivo criar um sistema de controle de estoque com **backend em Spring Boot**, acessível tanto por uma **interface web** quanto por um **aplicativo desktop (JavaFX)**.

---

## Tecnologias

### Backend
- [Spring Boot](https://spring.io/projects/spring-boot) → API REST, regras de negócio e conexão com o banco de dados  
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) → persistência de dados  
- [Spring Security](https://spring.io/projects/spring-security) → autenticação e autorização  

### Banco de Dados
- **PostgreSQL** (principal)  
- (Opcional) **MySQL/MariaDB** ou **SQLite** para versões locais  

### Frontend Web
- **Opção 1 (mais simples):** [Thymeleaf](https://www.thymeleaf.org/) integrado ao Spring Boot  
- **Opção 2 (mais moderno):** React / Angular / Vue consumindo a API REST  

### Desktop
- **JavaFX** → interface desktop conectada ao backend via API REST  
- (Opcional) **Swing** para protótipos ou versões legadas  

---

## Arquitetura do Projeto

controle-estoque/
├── backend/ (Spring Boot)
│   ├── controllers/   -> APIs REST
│   ├── services/      -> regras de negócio
│   ├── repositories/  -> acesso ao banco
│   └── models/        -> entidades (Produto, Usuario, Movimentacao)
│
├── frontend-web/ (opcional separado)
│   ├── React/Angular/Vue
│
├── desktop/ (JavaFX)
│   ├── telas/         -> interface desktop
│   └── services/      -> consome API REST do backend
│
└── db/ (PostgreSQL ou MySQL)



---
## 🛣️ Roadmap - Jogo de Pôquer JavaFX

### Fase 1 – Estrutura Básica
- Criar modelo do baralho e cartas
- Implementar lógica do jogo (Validador de mãos)
- Criar layout inicial no JavaFX

### Fase 2 – MVP
- Implementar modo **Five Card Draw**
- Criar tela de aposta e distribuição
- Mostrar resultado da rodada

### Fase 3 – Expansão
- Adicionar modo Texas Hold'em
- Criar IA simples para bots
- Implementar placar geral

### Fase 4 – Melhorias
- Melhorar UI com animações JavaFX
- Adicionar sistema de login
- Salvar estatísticas em banco de dados

### Fase 5 – Futuro
- Versão web (Spring Boot + React)
- Multiplayer online




------------------------------------------------------------------------------------

# 🃏 Roadmap - Jogo de Pôquer (Five Card Draw)

## Fase 1 – Estrutura Inicial
- Implementar lógica do jogo **Five Card Draw** (já concluído)
- Migrar para **JavaFX básico**
  - Criar tela inicial (menu simples)
  - Criar tela principal do jogo com placeholders para cartas

---

## Fase 2 - Persistência e Contas
- Criar **sistema de save** do jogo
  - Progresso do jogador (fichas, vitórias, itens/bebidas)
  - Progresso na lore / Bosses derrotados
- Implementar **conta de jogador** (nome, perfil, estatísticas)

## Fase 3 – Interface Visual
- Adicionar imagens das cartas (baralho completo em PNG/JPG)
- Mostrar cartas na mesa e na mão do jogador
- Implementar design inicial da interface (mesa, fichas, botões)

---

## Fase 4 – Sistema de Jogo
- Implementar sistema de **rodadas** (aposta, troca de cartas, showdown)
- Adicionar **apostas com fichas**
- Criar uma **IA básica** para adversário (ações simples: apostar, passar, trocar cartas)

---

## Fase 5 – Mecânicas Extras
- Criar sistema de **“bebidas”** que dão vantagens:
  - Café → aumenta concentração (melhora sorte na troca)
  - Uísque → efeito aleatório (às vezes ajuda, às vezes atrapalha)
  - Cerveja → reduz perdas (menos fichas apostadas em caso de derrota)
- Implementar classes específicas para manipular efeitos das bebidas

---

## Fase 6 – Lore e Narrativa
- Adicionar uma **sequência lógica de eventos** (roteiro básico)
- Inserir diálogos e pequenas cenas entre rodadas
- Criar progressão do jogador dentro de uma **história curta**

---

## Fase 7 – Adversários Especiais
- Implementar sistema de **“Bosses”**:
  - Cada Boss tem um estilo de jogo único
  - Adicionar falas e personalidades diferentes
- Criar progressão de dificuldade ao derrotar adversários

---

## Fase 8 – Polimento Visual e Experiência
- Lapidar animações de cartas e fichas
  - Adicionar transições e efeitos visuais
  - Melhorar layout e responsividade da interface

---

## Fase 9 – Futuro
- Melhorar IA com comportamento mais realista (blefes, leitura de jogo)
- Implementar modos extras além do Five Card Draw (Texas Hold’em, etc.)
- Criar versão online (multiplayer simples)