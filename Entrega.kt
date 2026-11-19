// Acompanha o andamento de um pedido
class Entrega(private val pedido: Pedido) {

    fun avancarStatus() {
        // proximo() devolve null quando o pedido já terminou
        val proximo = pedido.status.proximo()
        if (proximo == null) {
            println("Pedido #${pedido.numero} já foi finalizado (${pedido.status.descricao()}).")
            return
        }
        pedido.status = proximo
        println("Pedido #${pedido.numero}: ${pedido.status.descricao()}")
    }

    fun cancelar() {
        // Só dá para cancelar antes de sair para entrega
        if (pedido.status == StatusPedido.RECEBIDO || pedido.status == StatusPedido.EM_PREPARO) {
            pedido.status = StatusPedido.CANCELADO
            println("Pedido #${pedido.numero} cancelado.")
        } else {
            println("Pedido #${pedido.numero} não pode mais ser cancelado (${pedido.status.descricao()}).")
        }
    }
}
