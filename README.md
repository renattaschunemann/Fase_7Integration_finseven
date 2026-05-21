📋 Guia de Testes da API - Equipe FinSeven
Para facilitar a homologação das nossas rotas e garantir que todos testem a mesma estrutura, deixei a coleção completa de endpoints salva direto no repositório.

📥 1. Como Importar os Testes no Insomnia
Certifique-se de fazer o git pull para puxar a versão mais recente da branch.

Na raiz do projeto, você encontrará o arquivo: Testes de Requisição Finseven_Insomnia_2026-05-20.yaml.

Abra o seu Insomnia.

No canto superior esquerdo, clique no seu Workspace atual (ou em Preferences) e selecione Import/Export.

Clique em Import Data -> From File e selecione o arquivo .yaml que está na raiz do projeto.

Pronto! Uma pasta organizada com todas as nossas requisições HTTP (POST, GET, PUT, DELETE) aparecerá no seu painel.

🚀 2. Roteiro de Execução dos Testes (Ordem Obrigatória)
Como o nosso banco Oracle exige integridade de chaves estrangeiras, não tente criar uma transação ou investimento antes de criar a base. Siga rigorosamente esta ordem para evitar erros 500 ou chaves não encontradas:

Passo 1: Criar o Usuário (POST)
Rode primeiro o POST de Usuários.

Ele vai gerar um ID no banco (Ex: id: 1).

Passo 2: Criar a Conta Bancária (POST)
Rode o POST de Bancos para cadastrar a conta (Ex: Itaú).

Ele vai gerar o ID do banco (Ex: idBanco: 1).

Passo 3: Criar Investimentos e Transações (POST)
Agora você já pode rodar os testes de POST de Investimentos e de Transações (Receitas/Despesas).

Fique atento: No corpo do JSON dessas requisições, certifique-se de que os campos de relacionamento estão apontando para os IDs reais que você gerou nos Passos 1 e 2.

JSON:

{
"usuario": { "id": 1 },
"banco": { "idBanco": 1 }
}

⚠️ Atenção aos IDs na URL (Evitando o Erro 404)
Como estamos usando Sequences do Oracle (SQ_FINSEVEN_...), os IDs dos registros não vão começar necessariamente em 1, 2, 3... Eles seguem a numeração atual da sequence do banco.

Sempre rode o GET Geral primeiro (ex: GET /api/investimentos) para ver quais IDs o banco gerou (pode ser 5, 6, 7...).

Use o ID real que retornou no banco para testar as rotas de GET por ID, PUT (Atualizar) e DELETE (Excluir) na URL (ex: /api/investimentos/5).
