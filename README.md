
# TchêOrganiza  – App de Organização Acadêmica UFRGS

![Header](.github/header.png)

## Descrição

O **TchêOrganiza** é um aplicativo mobile em desenvolvimento como parte do Trabalho Prático da disciplina **Técnicas de Construção de Programas (2025/1 – UFRGS)**.

O objetivo é centralizar, de forma prática e intuitiva, as principais informações da vida acadêmica dos alunos da UFRGS, como grade de horários, tarefas, cardápio do RU e controle de tickets.

## Funcionalidades

- **Cadastro de Disciplinas:** Permite ao aluno registrar as disciplinas que está cursando no semestre, com dias, horários e outras informações relevantes.

- **Gestão de Tarefas:** Registro de atividades por disciplina (provas, trabalhos, laboratórios), com prazos e possibilidade de consulta rápida.

- **Controle de Tickets do RU:** Inserção manual de tickets comprados e registro do uso diário.

- **Visualização do Cardápio do RU:** Consulta ao cardápio semanal do Restaurante Universitário (PRAE/UFRGS).

- **Persistência Offline:** Dados do usuário salvos localmente, permitindo uso sem conexão constante à internet.

- **Interface Simples e Intuitiva:** Navegação focada na usabilidade, com acesso rápido às principais informações do dia.

## Requisitos Técnicos

- **Plataforma:** Android 
- **Linguagem:** Java
- **IDE:** Android Studio
- **Persistência de Dados:** (A definir – por enquanto, previsão de uso de armazenamento local simples)


## Estrutura de Pastas

```plaintext
root/
├── .github/                            # Arquivos de configuração do GitHub
├── docs/                               # Entregas e documentos do projeto
├── instructions/                       # Enunciados das etapas do trabalho
├── lib/                                # Dependências externas
│   └── jsoup-1.19.1.jar                # Biblioteca para scraping
├── src/                                # Código-fonte
│   ├── ScraperMenuRU.java              # Script Java para scraping do cardápio do RU
│   └── androidApplication/             # Projeto Android (estrutura padrão Gradle)
│       ├── app/
│       │   └── src/
│       │       ├── main/               # Código-fonte principal
│       │       │   ├── java/           # Pacotes Java (Activities, Fragments, ViewModels, etc.)
│       │       │   └── res/            # Recursos (layouts, drawables, valores, etc.)
│       │       ├── androidTest/        # Testes de Instrumentação
│       │       └── test/               # Testes unitários
│       ├── gradle/
│           └── wrapper/                # Wrapper do Gradle

```

## Como Rodar o Projeto

### Pré-requisitos

- **Android Studio** (recomendado: Electric Eel ou mais recente)
- **JDK 17** (ou versão compatível)
- **Dispositivo físico ou emulador** com Android 8.0 (API 26) ou superior

### Passo a Passo

1. Clone este repositório: `git clone git@github.com:SW-Engineering-Courses-Karina-Kohl/tcp-final-20251-grupo01.git`
2.	Abra o projeto no Android Studio:
    - Vá em **File > Open...** e selecione a pasta `src/androidApplication` do repositório clonado.
3.	Aguarde o Gradle sincronizar.
4.	Conecte um dispositivo físico ou inicie um emulador.
5.	Rode o app clicando em Run ▶️ ou com o atalho Shift + F10.

## Contribuidores

- **Adriel de Souza** – [@dsadriel](https://github.com/dsadriel)
- **Aline Fraga da Silva** – [@alinefragadasilvaa](https://github.com/alinefragadasilvaa)
- **Stefany Nascimento** – [@stefany-cn](https://github.com/stefany-cn)
- **Ana Luiza Colombi Sanfelice** – [@anasanfelice](https://github.com/anasanfelice)
- **Eduardo Veiga** – [@drdgfv](https://github.com/drdgfv)