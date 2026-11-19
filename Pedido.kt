// Representa um pedido já finalizado
class Pedido(
    val numero: Int,
    val cliente: Cliente,
    val itens: Map<Produto, Int>,
    val subtotal: Double,
    val desconto: Double,
    val taxaEntrega: Double
) {
    var status: StatusPedido = StatusPedido.RECEBIDO

    // Propriedade calculada: sempre reflete os valores atuais
    val total: Double
        get() = subtotal - desconto + taxaEntrega

    fun exibirResumo() {
        println("===== PEDIDO #$numero =====")
        println("Cliente: ${cliente.nome} | Tel: ${cliente.telefone}")
        println("Endereço: ${cliente.enderecoParaEntrega()}")
        for ((produto, quantidade) in itens) {
            println("${quantidade}x ${produto.nome} = ${(produto.preco * quantidade).paraReais()}")
        }
        println("Subtotal: ${subtotal.paraReais()}")
        println("Desconto: -${desconto.paraReais()}")
        println("Taxa de entrega: ${taxaEntrega.paraReais()}")
        println("TOTAL: ${total.paraReais()}")
        println("Status: ${status.descricao()}")
        println()
    }
}
