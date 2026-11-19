# FoodExpress

Sistema de delivery de comida em Kotlin (aplicação de console), desenvolvido para a disciplina de Programação.

## Funcionalidades

| Funcionalidade | Onde está |
| --- | --- |
| Cadastro de clientes | `Cliente.kt`, `FoodExpress.cadastrarCliente()` |
| Cardápio | `Cardapio.kt`, `Produto.kt` |
| Carrinho | `Carrinho.kt` |
| Pedidos | `Pedido.kt`, `FoodExpress.finalizarPedido()` |
| Pagamento | `Pagamento.kt` |
| Entrega | `Entrega.kt`, `StatusPedido.kt` |

## Conteúdos aplicados

- **POO:** classes `Cliente`, `Produto`, `Carrinho`, `Pedido`, `Entrega`, `FoodExpress`, `enum class` e `object`.
- **Variáveis:** preços, nomes, quantidades e status (`val` e `var`).
- **Operadores:** subtotal, desconto percentual e taxa de entrega.
- **If/Else:** validação para finalizar o pedido e regras de desconto e frete.
- **When:** status do pedido (`StatusPedido.kt`).
- **Laços de repetição:** `for` para o cardápio, carrinho e itens do pedido; `repeat` na simulação da entrega.
- **Null Safety:** endereço `String?`, `?.`, `?:`, `?.let` e retornos `Pedido?` e `Produto?`.

## Regras de negócio

- Desconto de 10% para compras a partir de R$ 100,00.
- Taxa de entrega de R$ 7,50, grátis a partir de R$ 150,00.
- Não é possível finalizar pedido com carrinho vazio ou cliente sem endereço.
- Só dá para cancelar um pedido antes de sair para entrega.

## Como executar

No IntelliJ IDEA, abra a pasta do projeto e execute a função `main` em `Main.kt`.
Ou, pelo terminal, com Gradle instalado: `gradle run`.
