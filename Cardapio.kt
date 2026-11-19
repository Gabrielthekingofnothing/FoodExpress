// Guarda a lista de produtos disponíveis
class Cardapio {
    val produtos: List<Produto> = listOf(
        Produto(1, "X-Burger", 25.0),
        Produto(2, "Pizza Margherita", 48.9),
        Produto(3, "Batata Frita", 14.5),
        Produto(4, "Refrigerante", 7.0),
        Produto(5, "Suco Natural", 9.5)
    )

    // Laço for percorrendo todos os produtos
    fun exibir() {
        println("===== CARDÁPIO FOODEXPRESS =====")
        for (produto in produtos) {
            println("${produto.id}. ${produto.nome} - ${produto.preco.paraReais()}")
        }
        println()
    }

    // Retorna Produto? porque o id pode não existir (Null Safety)
    fun buscarPorId(id: Int): Produto? = produtos.find { it.id == id }
}
