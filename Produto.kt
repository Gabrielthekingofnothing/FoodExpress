// Representa um item do cardápio.
// data class gera automaticamente equals, hashCode e toString.
data class Produto(
    val id: Int,
    val nome: String,
    val preco: Double
)
