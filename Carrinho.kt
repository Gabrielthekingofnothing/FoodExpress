// Carrinho de compras: guarda cada produto com sua quantidade
class Carrinho {
    private val itens = mutableMapOf<Produto, Int>()

    fun adicionar(produto: Produto, quantidade: Int = 1) {
        if (quantidade <= 0) {
            println("Quantidade inválida para ${produto.nome}.")
            return
        }
        // ?: 0 -> se o produto ainda não está no carrinho, começa do zero
        itens[produto] = (itens[produto] ?: 0) + quantidade
    }

    fun remover(produto: Produto, quantidade: Int = 1) {
        // Se o produto não está no carrinho, não há o que remover
        val atual = itens[produto] ?: return
        val novaQuantidade = atual - quantidade
        if (novaQuantidade > 0) {
            itens[produto] = novaQuantidade
        } else {
            itens.remove(produto)
        }
    }

    fun estaVazio(): Boolean = itens.isEmpty()

    // Soma preço x quantidade de cada item
    fun subtotal(): Double {
        var total = 0.0
        for ((produto, quantidade) in itens) {
            total += produto.preco * quantidade
        }
        return total
    }

    // Cópia somente leitura dos itens (para o pedido não alterar o carrinho)
    fun copiaDosItens(): Map<Produto, Int> = itens.toMap()

    fun exibir() {
        println("----- CARRINHO -----")
        if (estaVazio()) {
            println("Carrinho vazio.")
        } else {
            for ((produto, quantidade) in itens) {
                println("${quantidade}x ${produto.nome} = ${(produto.preco * quantidade).paraReais()}")
            }
            println("Subtotal: ${subtotal().paraReais()}")
        }
        println()
    }
}
