
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

- **Persistência Offline:** Dados do usuário serão salvos localmente para permitir uso sem conexão constante à internet. **Obs.: Esta funcionalidade ainda não foi implementada; atualmente, os dados são mantidos apenas durante a sessão do app.**

- **Interface Simples e Intuitiva:** Navegação focada na usabilidade, com acesso rápido às principais informações do dia.

## Requisitos Técnicos

- **Plataforma:** Android 
- **Linguagem:** Java
- **IDE:** Android Studio
- **Persistência de Dados:** (A definir – por enquanto, previsão de uso de armazenamento local simples)


## Estrutura de Pastas

## Visõo geral da estrutura de pastas do projeto:
<details>
<pre>
.
├── docs/                      # Documentos de entrega: PDFs das etapas, Perguntas e Apresentação (Keynote)
├── instructions/              # Enunciados oficiais de cada etapa do trabalho (PDFs das instruções)
├── src/androidApplication/    # Projeto Android completo (código-fonte, recursos e configuração Gradle)
│   ├── app/                   # Módulo principal do aplicativo Android
│   │   ├── build.gradle.kts   # Configuração Gradle específica do módulo
│   │   ├── proguard-rules.pro # Regras de obfuscação/optimização do código (ProGuard/R8)
│   │   └── src/
│   │       ├── main/          # Código-fonte principal (Java + recursos Android)
│   │       │   ├── AndroidManifest.xml
│   │       │   ├── java/      # Código Java dividido por pacotes
│   │       │   │   └── br.ufrgs.inf.tcp.tcheorganiza
│   │       │   └── res/       # Recursos Android (layouts XML, drawables, strings, cores, temas, etc)
│   │       ├── androidTest/   # Testes instrumentados (UI tests com Espresso)
│   │       └── test/          # Testes unitários (JUnit) para as classes Java
│   ├── build.gradle.kts       # Configuração de build do projeto Android
│   ├── gradle/                # Configuração de versões de dependências e Wrapper
├── README.md                  # Este arquivo
</pre>
</details>

## Estrutura Detalhada do Projeto Android (src/androidApplication/)
<details>
<pre>
src/androidApplication/
├── app/                                 # Módulo principal do projeto Android
│   ├── build.gradle.kts                  # Configuração Gradle específica do módulo (dependencies, plugins, etc)
│   ├── proguard-rules.pro                # Regras para minificação e obfuscação (ProGuard/R8)
│   └── src/
│       ├── main/                         # Código-fonte e recursos usados no app final
│       │   ├── AndroidManifest.xml       # Manifesto Android (declara Activities, permissões, etc)
│       │   ├── java/
│       │   │   └── br/ufrgs/inf/tcp/tcheorganiza/
│       │   │       ├── MainActivity.java                   # Activity principal (ponto de entrada)
│       │   │       ├── StartingPageActivity.java          # Tela de início
│       │   │       ├── PreferenceRuActivity.java          # Tela de preferências relacionadas ao RU
│       │   │       ├── NewClassActivity.java              # Tela de cadastro de disciplinas
│       │   │       ├── NewProfessorActivity.java          # Tela de cadastro de professores
│       │   │       ├── NewTaskActivity.java               # Tela de cadastro de tarefas
│       │   │       ├── model/                             # Modelos de dados
│       │   │       │   ├── courses/                       # Estruturas de dados para Disciplinas e Professores
│       │   │       │   ├── ru/                            # Estruturas para RU (Cardápio, Tickets, etc)
│       │   │       │   └── tasks/                         # Estruturas de Tarefas (Lab, Trabalho, Prova, etc)
│       │   │       ├── persistence/                       # Persistência local
│       │   │       ├── recyclerviewadapters/              # Adapters para listas com RecyclerView
│       │   │       ├── subjectManager/                    # Gerenciamento de Disciplinas
│       │   │       ├── ui/                                # Fragments e telas divididas por funcionalidade
│       │   │       │   ├── cardapio/                      # UI relacionada ao cardápio do RU
│       │   │       │   ├── disciplinas/                   # UI para Disciplinas (cadastro, listagem, etc)
│       │   │       │   ├── home/                          # Tela inicial (HomeFragment)
│       │   │       │   ├── professor/                     # UI de Professores
│       │   │       │   ├── tasks/                         # UI de Tarefas
│       │   │       │   └── ticketru/                      # UI para gerenciamento de tickets RU
│       │   │       └── Utils.java                         # Classe utilitária com métodos auxiliares
│       │   └── res/                                        # Recursos gráficos, de texto e layout
│       │       ├── color/                                 # Cores
│       │       ├── drawable/                              # Imagens vetoriais e shapes
│       │       ├── layout/                                # Layouts XML das telas e fragments
│       │       ├── menu/                                  # Menus (ex: BottomNavigation)
│       │       ├── navigation/                            # Navigation Graph (estrutura de navegação entre telas)
│       │       ├── values/                                # Strings, dimensões, estilos e temas
│       │       └── xml/                                   # Regras adicionais do sistema (ex: backup)
│       └── test/                                          # Testes unitários (JUnit)
│           └── java/
│               └── br/ufrgs/inf/tcp/tcheorganiza/
│                   ├── CardapioTest.java
│                   ├── CourseTest.java
│                   ├── ExamTest.java
│                   ├── HorarioFuncionamentoTest.java
│                   ├── LabTest.java
│                   ├── LocalizacaoTest.java
│                   ├── OfficeTest.java
│                   ├── OrganizadorRusTest.java
│                   ├── RegistroTicketsTest.java
│                   ├── RuTest.java
│                   ├── ScheduleTest.java
│                   ├── TaskTest.java
│                   ├── TeacherTest.java
│                   ├── TicketTest.java
│                   └── WorkTest.java
├── build.gradle.kts          # Configuração de build do projeto (nível raiz)
├── gradle/                   # Configuração de versões e Wrapper
├── gradle.properties
├── gradlew                   # Script Gradle Wrapper (Linux/macOS)
├── gradlew.bat               # Script Gradle Wrapper (Windows)
└── settings.gradle.kts       # Configuração de inclusão de módulos no projeto
</pre>
</details>

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