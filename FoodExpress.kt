// Classe principal do sistema: cadastra clientes e registra pedidos
class FoodExpress {
    private val clientes = mutableListOf<Cliente>()
    private val pedidos = mutableListOf<Pedido>()
    private var proximoNumero = 1

    fun cadastrarCliente(nome: String, telefone: String, endereco: String? = null): Cliente {
        val cliente = Cliente(nome, telefone, endereco)
        clientes.add(cliente)
        println("Cliente cadastrado: $nome")
        return cliente
    }

    // Retorna Pedido? -> null quando não é possível finalizar
    fun finalizarPedido(cliente: Cliente, carrinho: Carrinho): Pedido? {
        if (carrinho.estaVazio()) {
            println("Não foi possível finalizar: o carrinho está vazio.")
            return null
        } else if (!cliente.temEnderecoValido()) {
            println("Não foi possível finalizar: ${cliente.nome} não tem endereço cadastrado.")
            return null
        }

        val subtotal = carrinho.subtotal()
        val pedido = Pedido(
            numero = proximoNumero++,
            cliente = cliente,
            itens = carrinho.copiaDosItens(),
            subtotal = subtotal,
            desconto = Pagamento.calcularDesconto(subtotal),
            taxaEntrega = Pagamento.calcularTaxaEntrega(subtotal)
        )
        pedidos.add(pedido)
        println("Pedido #${pedido.numero} registrado com sucesso!")
        return pedido
    }
}
