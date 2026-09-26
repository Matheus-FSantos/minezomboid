# Contexto Atualizado do Projeto: MineZomboid Core (Minecraft 1.21)

## 📌 Visão Geral do Projeto

Desenvolvimento de um mod **Server-side** para Minecraft na versão **1.21** (utilizando **Java 21** e os **Mojang Mappings oficiais**), estruturado através da **Fabric API**.

O objetivo é transformar o Minecraft original em um simulador de sobrevivência **hardcore, urbano e realista**, fortemente inspirado em *Project Zomboid*.

O projeto também possui um objetivo técnico de portfólio: o código deve seguir padrões de desenvolvimento backend corporativo, incluindo **Clean Code, separação de responsabilidades, encapsulamento por domínios, logging via SLF4J e arquitetura orientada a dados**, sem sacrificar a simplicidade necessária para um mod.

O mod será desenvolvido inicialmente de forma solo e posteriormente testado em um servidor online com amigos, permitindo validar as mecânicas não apenas tecnicamente, mas também do ponto de vista de gameplay.

---

# 🎮 Filosofia de Gameplay

Uma das principais decisões de design estabelecidas durante o desenvolvimento é:

> **A dificuldade do MineZomboid deve vir principalmente da escassez e da exploração, e não de árvores de crafting excessivamente complexas.**

O objetivo não é transformar cada item em uma cadeia enorme de materiais intermediários.

Exemplo:

```text
Plastic × 3
     ↓
Plastic Bottle
```

E não:

```text
Plastic
 ↓
Plastic Sheet
 ↓
Plastic Component
 ↓
Container Part
 ↓
Plastic Bottle
```

A primeira abordagem é preferível.

O jogador deve pensar:

> "Eu sei como fazer isso. O problema é encontrar os recursos."

e não:

> "Eu tenho os recursos, mas preciso descobrir cinco etapas de crafting."

### Progressão baseada em exploração

A progressão do jogador deve acontecer principalmente através de:

```text
Exploração
    ↓
Loot
    ↓
Recursos encontrados
    ↓
Novas possibilidades
    ↓
Maior capacidade de sobrevivência
```

Os itens podem ser relativamente simples de utilizar, mas sua **aquisição pode ser difícil, aleatória e dependente do local explorado**.

Um recurso pode aparecer em uma casa, mas não necessariamente em todas as casas.

Isso cria situações emergentes como:

```text
Casa 1 → nada
Casa 2 → comida
Casa 3 → bandagem
Casa 4 → Plastic
Casa 5 → nada
...
Casa 10 → Plastic
```

O jogador que encontrar recursos cedo terá uma experiência diferente daquele que precisar sobreviver utilizando alternativas improvisadas.

---

# 🌊 Exemplo de Design: Água

A mecânica de água representa bem essa filosofia.

O jogador pode:

```text
Encontrar Plastic
       ↓
Plastic × 3
       ↓
Plastic Bottle
       ↓
Coletar água
       ↓
Water Bottle
```

Porém, a garrafa **não deve ser obrigatória para sobreviver**.

Caso o jogador não encontre plástico, ele ainda pode recorrer a fontes naturais, como rios.

Isso significa que:

> **Itens importantes devem facilitar a sobrevivência, mas nem sempre ser requisitos absolutos para continuar jogando.**

O objetivo é criar decisões e histórias emergentes, não bloqueios artificiais.

---

# 🧱 Primeiros Materiais Base

Foi definido um primeiro conjunto pequeno de materiais para começar a construir o sistema de loot e crafting.

Neste momento, eles devem ser tratados principalmente como **itens base**, sem inventar interações prematuras.

| Item                   | ID / Inglês   | Função atual                                                        |
| ---------------------- | ------------- | ------------------------------------------------------------------- |
| **Plástico**           | `plastic`     | Material base. Sem interação direta com o jogador neste momento.    |
| **Tecido**             | `cloth`       | Material base. Sem interação direta com o jogador neste momento.    |
| **Papel**              | `paper`       | Material base. Sem interação direta com o jogador neste momento.    |
| **Fita adesiva preta** | `duct_tape`   | Material base. Sem interação direta com o jogador neste momento.    |
| **Kit médico**         | `medical_kit` | Primeiro item base com potencial de interação direta com o jogador. |

### Regra atual

Com exceção do **Kit Médico**, esses materiais **não terão comportamento próprio inicialmente**.

Eles devem simplesmente:

```text
existir
↓
aparecer no inventário
↓
poder ser encontrados através de loot
↓
posteriormente ganhar usos através de receitas/mecânicas
```

Não devemos criar usos artificiais apenas para justificar a existência do item.

Os usos serão definidos conforme o design do jogo evoluir.

---

# 🧴 Itens de Sobrevivência Já Existentes

O primeiro sistema funcional implementado foi o das garrafas.

### Plastic Bottle

Representa a garrafa vazia.

```text
Plastic × 3
      ↓
Plastic Bottle
```

### Water Bottle

Representa a garrafa contendo água.

A implementação atual permite:

* coletar água;
* consumir água;
* controlar o comportamento do recipiente;
* executar as regras de inventário relacionadas à garrafa.

O fluxo de água foi o primeiro sistema completo validado dentro do jogo.

---

# 🎨 Direção Visual Oficial dos Assets

Foi estabelecido um padrão visual para todos os novos assets do MineZomboid.

Os assets devem seguir uma identidade visual consistente, de forma que itens diferentes pareçam pertencer ao **mesmo inventário e ao mesmo jogo**.

### Padrão visual

* Pixel art.
* Aparência de item de inventário.
* Estética de survival pós-apocalíptico urbano.
* Visual levemente desgastado, usado e sujo.
* Paleta relativamente limitada e dessaturada.
* Silhueta simples e facilmente reconhecível.
* Objeto centralizado.
* Perspectiva consistente.
* Fundo transparente.
* Pixels nítidos.
* Sem anti-aliasing.
* Sem texto.
* Sem watermark.
* Boa legibilidade em tamanho pequeno.
* Todos os assets devem compartilhar a mesma linguagem visual.

### Regra de ouro

> **O asset deve parecer um objeto que poderia ser encontrado no mundo abandonado do MineZomboid.**

O estilo visual atual foi validado através dos primeiros assets gerados para:

```text
Plastic
Cloth
Paper
Duct Tape
Medical Kit
```

Esses assets estabeleceram a **base visual do jogo** e devem servir como referência para a geração dos próximos itens.

Cada asset deve seguir a mesma estrutura de prompt, alterando principalmente a descrição do objeto:

```
Pixel art game item icon, [DESCRIÇÃO ESPECÍFICA DO ITEM], Minecraft-inspired survival game aesthetic, post-apocalyptic urban survival, simple readable silhouette, centered object, isolated, transparent background, limited color palette, crisp hard pixels, no anti-aliasing, no text, no watermark, high readability at small resolution, 16-bit pixel art style.
```

Exemplo — Duct Tape

```
Pixel art game item icon, a small roll of black duct tape, slightly worn and scratched, realistic compact roll shape, Minecraft-inspired survival game aesthetic, post-apocalyptic urban survival, simple readable silhouette, centered object, isolated, transparent background, limited color palette, crisp hard pixels, no anti-aliasing, no text, no watermark, high readability at small resolution, 16-bit pixel art style.
```
---

# 🏙️ Loot e Exploração

O sistema de loot será uma das principais formas de progressão.

Itens não precisam possuir uma única origem.

A mesma categoria de recurso pode aparecer em diferentes ambientes, mas com probabilidades diferentes.

Exemplo:

```text
Casa
├── Plastic
├── Cloth
└── Paper

Garagem
├── Duct Tape
├── Metal
└── Ferramentas

Hospital
├── Medical Kit
├── Cloth
└── Itens médicos
```

Isso permite que determinados locais tenham valor estratégico.

O jogador pode pensar:

> "Preciso de fita. Talvez uma garagem seja um lugar melhor para procurar."

A exploração urbana passa, portanto, a funcionar como parte da progressão.

---

# 🛠️ Arquitetura Técnica Atual

A estrutura atual do módulo `main` está organizada sob o domínio:

```text
io.github.minezomboid
```

Estrutura atual:

```text
src/main/java/io/github/minezomboid/
│
├── MineZomboid.java
│
├── init/
│   ├── ModItemIds.java
│   ├── ModItems.java
│   ├── PlasticBottleItem.java
│   └── WaterBottleItem.java
│
└── utils/constants/
    └── MineZomboidConstants.java
```

### Responsabilidades

`MineZomboid.java`

Entrypoint principal / `ModInitializer`.

`ModItemIds.java`

Helper responsável pela criação das `ResourceKey` dos itens.

`ModItems.java`

Centralização das instâncias e registros dos itens.

`PlasticBottleItem.java`

Comportamento da garrafa vazia, incluindo interação com fluidos.

`WaterBottleItem.java`

Comportamento da garrafa cheia, consumo, animação e regras de inventário.

`MineZomboidConstants.java`

Constantes globais, incluindo `MOD_ID`.

---

# ⚙️ Regras Técnicas Descobertas

Durante a configuração do ambiente e implementação inicial foram identificadas algumas características importantes do ecossistema Fabric/Minecraft 1.21:

1. O projeto possui separação física entre `main` e `client`.

2. O sistema moderno utiliza uma abordagem Data-Driven para diversos recursos.

3. Os itens utilizam `ResourceKey<Item>` associado ao registro apropriado.

4. A criação de `ResourceLocation` segue a API moderna utilizada pelo ambiente configurado.

5. Algumas APIs de conveniência fornecidas pelo ecossistema Fabric/Loom podem não aparecer corretamente para a IDE em determinados contextos.

6. Para reduzir dependências desnecessárias de APIs de conveniência, a implementação atual prioriza contratos explícitos e registro direto através das APIs disponíveis.

---

# 🎨 Data Generation

O projeto utiliza **Data Generation** para automatizar a geração dos recursos JSON.

### Recursos

```text
src/main/resources/assets/minezomboid/
└── textures/
    └── item/
```

As texturas dos itens são armazenadas nessa estrutura.

### `ModModelProvider`

Responsável pela geração dos modelos dos itens utilizando templates apropriados para itens planos.

### `ModLanguageProvider`

Responsável pelas traduções dos itens.

Exemplo:

```text
item.minezomboid.plastic_bottle
        ↓
Plastic Bottle
```

### `MineZomboidDataGenerator`

Entrypoint responsável por executar os providers de geração de dados.

---

# 📍 Estado Atual do Projeto

O primeiro ciclo funcional do projeto foi concluído:

```text
Plastic Bottle
      ↓
coleta de água
      ↓
Water Bottle
      ↓
consumo de água
```

O sistema foi compilado e validado no servidor.

Também foi estabelecida a primeira identidade visual oficial do mod.

### Itens atualmente planejados para a próxima etapa

```text
Plastic
Cloth
Paper
Duct Tape
Medical Kit
```

Neste momento, os quatro primeiros são apenas materiais base, enquanto o Kit Médico será posteriormente conectado ao sistema de tratamento/ferimentos.

---

# 🧭 Próxima Etapa

A próxima etapa imediata é adicionar os cinco novos itens base:

```text
Plastic
Cloth
Paper
Duct Tape
Medical Kit
```

O foco inicial deve ser somente:

```text
Registro
↓
Textura
↓
Model
↓
Translation
↓
Data Generation
↓
Validação no Minecraft
```

Não adicionar comportamento desnecessário aos materiais neste momento.

Depois disso, os usos dos materiais serão definidos progressivamente conforme o design do jogo for sendo fechado.

---

# 🧠 Princípios de Design Definidos

### 1. Simplicidade no crafting

Evitar cadeias artificiais de crafting.

### 2. Escassez no mundo

A dificuldade deve vir principalmente da disponibilidade dos recursos.

### 3. Exploração como progressão

O jogador evolui principalmente através daquilo que encontra.

### 4. Alternativas de sobrevivência

Um item importante pode facilitar uma tarefa sem necessariamente ser obrigatório para sobreviver.

### 5. Complexidade emergente

As mecânicas devem surgir da combinação de sistemas simples.

### 6. Não implementar por implementar

Uma ideia tecnicamente interessante só entra no jogo se fizer sentido para a experiência de sobrevivência.

### 7. Definir escopos gradualmente

Os usos dos materiais e sistemas não precisam ser decididos antecipadamente.

O projeto será desenvolvido de forma incremental:

```text
Item
 ↓
Teste
 ↓
Gameplay
 ↓
Feedback
 ↓
Novo uso
 ↓
Nova mecânica
```

A experiência jogando com amigos será utilizada para validar e ajustar as decisões de design.

### 8. Consistência visual

Todo novo asset deve seguir o padrão visual estabelecido pelos primeiros itens.

---

# 🧟 Visão de Longo Prazo

O MVP completo deverá evoluir progressivamente para:

```text
Loot urbano
    ↓
Exploração
    ↓
Recursos escassos
    ↓
Crafting simples
    ↓
Sobrevivência
    ↓
Ferimentos
    ↓
Zumbis
    ↓
Hordas
    ↓
Cidades abandonadas
    ↓
Experiência de survival multiplayer
```

Os sistemas maiores planejados continuam sendo:

* Filtro de spawn de criaturas fantásticas.
* Sistema de ferimentos.
* Desativação da regeneração natural.
* Loot por ambiente/cômodo.
* Geração procedural de cidades.
* Sistema de atração de zumbis por som (IA).
* Inteligência de hordas.
* Sistemas de sobrevivência adicionais.

Esses sistemas serão implementados somente conforme os fundamentos do gameplay forem sendo estabelecidos.
