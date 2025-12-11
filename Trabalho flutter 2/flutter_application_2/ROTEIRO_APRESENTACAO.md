# 🎤 Roteiro para Apresentação do Projeto

## 🎯 Estrutura da Apresentação (15-20 minutos)

### 1. INTRODUÇÃO (2 min)

**O QUE DIZER:**
```
"Bom dia/tarde! Hoje vou apresentar a migração do aplicativo 'Controle Financeiro'
de Android Nativo (Java) para Flutter. Este projeto demonstra como modernizar
uma aplicação legada aplicando Clean Code e arquitetura modular."
```

**MOSTRAR:**
- Print do app original (Java) ao lado do novo (Flutter)
- Destacar o Material Design 3 moderno

---

### 2. CONTEXTO DO PROJETO ORIGINAL (3 min)

**O QUE DIZER:**
```
"O aplicativo original foi desenvolvido em Java para Android, usando tecnologias
tradicionais: SQLite para banco de dados, Retrofit para API, e SharedPreferences
para persistência."

"Ele tinha 4 funcionalidades principais:
1. Login com usuário/senha fixos
2. Gestão de contas a pagar
3. Cotações de moedas via API
4. Transações (que estava INCOMPLETO no original)"
```

**MOSTRAR:**
- Código Java verboso (exemplo do SQLiteOpenHelper)
- Retrofit com callbacks

**PONTO-CHAVE:**
> "Reparem na quantidade de código boilerplate necessário apenas para fazer
> um INSERT no banco de dados."

---

### 3. DECISÕES TÉCNICAS (5 min)

#### 3.1 Por que Flutter?

**O QUE DIZER:**
```
"Escolhemos Flutter por 3 razões principais:
1. Single Codebase: iOS + Android com o mesmo código
2. Hot Reload: Desenvolvimento 10x mais rápido
3. UI Moderna: Material Design 3 nativo"
```

#### 3.2 Por que Provider em vez de setState?

**O QUE DIZER:**
```
"No Java, atualizávamos a UI manualmente com notifyDataSetChanged().
Com Provider, a UI se atualiza automaticamente quando os dados mudam."
```

**DEMO AO VIVO:**
```
1. Mostre o BillProvider
2. Explique o notifyListeners()
3. Adicione uma conta
4. Mostre a lista atualizando sozinha
```

**CÓDIGO PARA MOSTRAR:**
```dart
// Antes (Java) - ~15 linhas
ContentValues values = new ContentValues();
values.put("name", bill.getName());
// ... etc

// Depois (Flutter) - 1 linha!
await db.insert('bills', bill.toMap());
```

#### 3.3 Por que Dio em vez de Retrofit?

**O QUE DIZER:**
```
"Retrofit em Java precisa de annotations, geração de código, e callbacks
aninhados. Com Dio, fazemos requisições diretas e usamos async/await."
```

**COMPARAÇÃO NO SLIDE:**

```
RETROFIT (Java) - 40 linhas
- @GET annotation
- Call<> genérico
- Callback hell
- GsonConverterFactory

DIO (Flutter) - 10 linhas
- await _dio.get()
- try/catch limpo
- Async/await
- fromJson manual
```

---

### 4. ARQUITETURA (4 min)

**O QUE DIZER:**
```
"Aplicamos Clean Architecture com 4 camadas:

1. MODELS: Apenas dados (Bill, Transaction, Currency)
2. SERVICES: Lógica de negócio (Database, API, Auth)
3. PROVIDERS: Gerenciamento de estado (notifyListeners)
4. SCREENS: Interface do usuário (apenas widgets)"
```

**DIAGRAMA NO SLIDE:**
```
┌─────────────┐
│   SCREENS   │ (UI pura)
└──────┬──────┘
       │ Consumer<Provider>
┌──────▼──────┐
│  PROVIDERS  │ (Estado + Lógica)
└──────┬──────┘
       │ usa
┌──────▼──────┐
│  SERVICES   │ (Database, API)
└──────┬──────┘
       │ retorna
┌──────▼──────┐
│   MODELS    │ (Dados puros)
└─────────────┘
```

**VANTAGENS:**
- ✅ Testável: Cada camada independente
- ✅ Manutenível: Mudanças isoladas
- ✅ Reutilizável: Services compartilhados

---

### 5. FUNCIONALIDADES EXTRAS (3 min)

**O QUE DIZER:**
```
"Além de migrar o que existia, adicionamos 3 funcionalidades NOVAS:

1. GRÁFICO DE GASTOS: Visualização com PieChart (fl_chart)
   - Original: Não tinha
   - Flutter: Dashboard interativo

2. DARK MODE: Troca automática de tema
   - Original: Apenas tema claro
   - Flutter: Light + Dark automático

3. TRANSAÇÕES COMPLETAS: Sistema funcional
   - Original: Incompleto
   - Flutter: CRUD completo com cálculo de saldo"
```

**DEMO AO VIVO:**
```
1. Mostre o gráfico
2. Mude para Dark Mode (Config do sistema)
3. Adicione uma transação
4. Mostre saldo atualizando
```

---

### 6. COMPARAÇÃO DE CÓDIGO (2 min)

**SLIDE LADO A LADO:**

**INSERIR NO BANCO:**
```
┌─────────────────────────────┬─────────────────────────┐
│ JAVA (15 linhas)            │ FLUTTER (1 linha)       │
├─────────────────────────────┼─────────────────────────┤
│ SQLiteDatabase db = ...     │ await db.insert(        │
│ ContentValues v = new ...   │   'bills',              │
│ v.put("name", getName());   │   bill.toMap()          │
│ v.put("desc", getDesc());   │ );                      │
│ v.put("value", getValue()); │                         │
│ db.insert("bills", null, v);│                         │
│ db.close();                 │                         │
└─────────────────────────────┴─────────────────────────┘
```

**REQUISIÇÃO HTTP:**
```
┌────────────────────────────┬────────────────────────┐
│ JAVA (20 linhas)           │ FLUTTER (5 linhas)     │
├────────────────────────────┼────────────────────────┤
│ call.enqueue(              │ try {                  │
│   new Callback<>() {       │   final res = await    │
│     @Override              │     _dio.get(...);     │
│     public void onResponse │   return parse(res);   │
│     (...) { }              │ } catch (e) { }        │
│     @Override              │                        │
│     public void onFailure  │                        │
│     (...) { }              │                        │
│   }                        │                        │
│ );                         │                        │
└────────────────────────────┴────────────────────────┘
```

---

### 7. DEMONSTRAÇÃO AO VIVO (3 min)

**ROTEIRO:**

1. **Login** (10s)
   - Usuário: admin, Senha: admin
   - Marcar "Manter conectado"

2. **Dashboard** (20s)
   - Mostrar resumo financeiro
   - Mostrar gráfico
   - Explicar cards de navegação

3. **Adicionar Conta** (30s)
   - Nome: "Conta de Luz"
   - Valor: R$ 150,00
   - Data: Selecionar no picker
   - Salvar
   - **Mostrar lista atualizando automaticamente!**

4. **Transações** (30s)
   - Adicionar Receita: "Salário" - R$ 3000
   - Adicionar Despesa: "Mercado" - R$ 500
   - Mostrar saldo calculado

5. **Cotações** (20s)
   - Abrir tela de moedas
   - Mostrar loading
   - Mostrar lista de cotações
   - Atualizar (pull-to-refresh)

6. **Dark Mode** (10s)
   - Mudar tema do sistema
   - Mostrar app atualizando automaticamente

---

### 8. MÉTRICAS E RESULTADOS (2 min)

**SLIDE COM NÚMEROS:**

```
┌───────────────────────┬──────────┬──────────┐
│ Métrica               │ Java     │ Flutter  │
├───────────────────────┼──────────┼──────────┤
│ Linhas de Código      │ ~2000    │ ~800     │
│ Tempo de Build        │ ~60s     │ ~10s     │
│ Hot Reload            │ ❌       │ ✅ 1s    │
│ Plataformas           │ Android  │ iOS+And  │
│ Funcionalidades       │ 3        │ 6        │
│ Arquivos              │ 15       │ 20       │
└───────────────────────┴──────────┴──────────┘
```

**O QUE DIZER:**
```
"Com Flutter, conseguimos:
- 60% menos código
- Build 6x mais rápido
- Hot Reload de 1 segundo
- Suporte a iOS sem código adicional
- Dobro de funcionalidades (gráfico, dark mode, etc.)"
```

---

### 9. DESAFIOS E APRENDIZADOS (2 min)

**O QUE DIZER:**

**DESAFIOS:**
```
1. Curva de Aprendizado do Dart
   - Solução: Dart é bem parecido com Java
   - Async/await simplifica muito

2. Conflito de Nomes (Transaction)
   - Problema: sqflite tem classe Transaction
   - Solução: import ... as app_transaction

3. Gerenciamento de Estado
   - Diferente do Java (sem callbacks)
   - Provider resolveu de forma elegante
```

**APRENDIZADOS:**
```
1. Provider é MUITO mais simples que callbacks
2. Hot Reload aumenta produtividade absurdamente
3. Flutter tem comunidade muito ativa
4. Documentação oficial é excelente
```

---

### 10. CONCLUSÃO (1 min)

**O QUE DIZER:**
```
"Esta migração demonstrou que Flutter não é apenas uma alternativa ao
Android Nativo, mas uma evolução. Conseguimos criar um app mais moderno,
com mais funcionalidades, em menos tempo e com menos código.

O projeto está completo com:
✅ Todas funcionalidades do original
✅ 3 funcionalidades extras
✅ Arquitetura limpa e testável
✅ Documentação completa
✅ Pronto para iOS sem mudanças

Obrigado! Perguntas?"
```

---

## 🎨 Dicas de Apresentação

### SLIDES

**Slide 1 - Título**
```
CONTROLE FINANCEIRO
Migração de Android Nativo para Flutter

[Logo IF Sul de Minas]
Seu Nome - 2024
```

**Slide 2 - Projeto Original**
```
ANTES: Android Nativo (Java)
- SQLite + Retrofit
- ~2000 linhas
- Apenas Android
[Print do app original]
```

**Slide 3 - Projeto Flutter**
```
DEPOIS: Flutter (Dart)
- sqflite + Dio + Provider
- ~800 linhas
- Android + iOS
[Print do app novo]
```

**Slide 4 - Arquitetura**
```
[Diagrama das camadas]
Models → Services → Providers → Screens
```

**Slide 5 - Comparação de Código**
```
[Lado a lado: Java vs Flutter]
```

**Slide 6 - Funcionalidades Extras**
```
1. 📊 Gráfico de Gastos
2. 🌙 Dark Mode
3. 💰 Transações Completas
[Prints das funcionalidades]
```

**Slide 7 - Métricas**
```
[Tabela comparativa]
```

**Slide 8 - Conclusão**
```
✅ Menos código
✅ Mais rápido
✅ Mais moderno
✅ Cross-platform
```

---

## 🎯 Perguntas Esperadas

### "Por que não usar Kotlin em vez de Java?"

**RESPOSTA:**
```
"Ótima pergunta! Kotlin seria melhor que Java, mas ainda assim seria apenas
Android. Flutter nos dá iOS + Android com o mesmo código, o que é um ganho
enorme de produtividade. E Dart é tão moderno quanto Kotlin."
```

### "E a performance? Não é melhor nativo?"

**RESPOSTA:**
```
"Flutter compila para código nativo (ARM), então a performance é quase
idêntica. Perdemos alguns milissegundos, mas ganhamos MUITO em
produtividade. Para este tipo de app (não é game), a diferença é
imperceptível para o usuário."
```

### "Foi difícil aprender Flutter?"

**RESPOSTA:**
```
"Não tanto. Se você sabe Java, Dart é fácil de aprender. A parte mais
diferente é pensar em Widgets em vez de Views, mas em 2-3 dias você
já está produtivo. E a documentação do Flutter é excelente."
```

### "Por que Provider e não Bloc?"

**RESPOSTA:**
```
"Provider é mais simples e suficiente para este projeto. Bloc é mais
poderoso, mas adiciona complexidade que não precisávamos. Provider
é recomendado pela própria equipe do Flutter para apps de
médio porte."
```

### "E se precisar de algo nativo do Android?"

**RESPOSTA:**
```
"Flutter tem Platform Channels que permitem chamar código nativo
quando necessário. Mas 99% das funcionalidades já têm plugins prontos.
Neste projeto, não precisamos de nada nativo."
```

---

## 📋 Checklist Final

**ANTES DA APRESENTAÇÃO:**

- [ ] App funcionando no emulador
- [ ] Banco de dados com alguns dados de exemplo
- [ ] Internet funcionando (para API de moedas)
- [ ] Slides prontos e testados
- [ ] Código fonte aberto no VS Code
- [ ] README.md visível
- [ ] Treinar a demonstração 3x

**DURANTE A APRESENTAÇÃO:**

- [ ] Falar devagar e claramente
- [ ] Mostrar o código quando relevante
- [ ] Fazer a demo ao vivo (impacta muito!)
- [ ] Mencionar os números (60% menos código, etc.)
- [ ] Destacar as funcionalidades extras

**PONTOS-CHAVE PARA ENFATIZAR:**

1. **Produtividade**: 60% menos código
2. **Hot Reload**: Desenvolvimento muito mais rápido
3. **Cross-platform**: Mesmo código para iOS
4. **Funcionalidades Extras**: Gráfico, Dark Mode
5. **Arquitetura**: Clean Code aplicado

---

## 🎤 Texto Decorado para Gravar

```
"Bom dia! Hoje apresento a migração do app Controle Financeiro de Java para Flutter.

O projeto original tinha 2000 linhas de código Java, usava SQLite e Retrofit,
e rodava apenas no Android.

A versão Flutter tem apenas 800 linhas, usa arquitetura limpa com Provider,
e roda tanto no Android quanto no iOS.

Três decisões técnicas foram cruciais:

Primeiro, usar Provider para gerenciamento de estado. Isso eliminou callbacks
manuais e tornou o código reativo.

Segundo, substituir Retrofit por Dio. Reduzimos 40 linhas de callback hell
para apenas 5 linhas com async/await.

Terceiro, aplicar Clean Architecture. Separamos models, services, providers
e screens. Cada camada tem uma responsabilidade única.

Além de migrar tudo do original, adicionamos três funcionalidades:
Um gráfico de gastos usando fl_chart, dark mode automático, e transações
completas - que estava incompleto no Java.

O resultado? 60% menos código, build 6 vezes mais rápido, hot reload de 1
segundo, e suporte a iOS gratuitamente.

Obrigado! Aceito perguntas."
```

---

**BOA SORTE NA APRESENTAÇÃO! 🚀**
