// Demonstração do FoodExpress: percorre todas as funcionalidades
fun main() {
    val sistema = FoodExpress()
    val cardapio = Cardapio()

    // 1. Cadastro de clientes (a segunda não informa endereço: valor nulo)
    val maria = sistema.cadastrarCliente("Maria Silva", "(11) 99999-1111", "Rua das Flores, 123")
    val joao = sistema.cadastrarCliente("João Souza", "(11) 98888-2222")
    println()

    // 2. Cardápio
    cardapio.exibir()

    // 3. Carrinho da Maria (buscarPorId pode devolver null, por isso o ?.let)
    val carrinhoMaria = Carrinho()
    cardapio.buscarPorId(1)?.let { carrinhoMaria.adicionar(it, 2) }
    cardapio.buscarPorId(2)?.let { carrinhoMaria.adicionar(it) }
    cardapio.buscarPorId(4)?.let { carrinhoMaria.adicionar(it, 2) }
    cardapio.buscarPorId(3)?.let { carrinhoMaria.adicionar(it) }
    cardapio.buscarPorId(3)?.let { carrinhoMaria.remover(it) }   // remove a batata
    cardapio.buscarPorId(99)?.let { carrinhoMaria.adicionar(it) } // id inexistente: ignorado
    carrinhoMaria.exibir()

    // 4. Pedido finalizado com sucesso
    val pedidoMaria = sistema.finalizarPedido(maria, carrinhoMaria)
    println()
    pedidoMaria?.exibirResumo()

    // 5. Tentativa de pedido sem endereço
    val carrinhoJoao = Carrinho()
    cardapio.buscarPorId(3)?.let { carrinhoJoao.adicionar(it) }
    sistema.finalizarPedido(joao, carrinhoJoao)
    println()

    // 6. Acompanhamento da entrega
    if (pedidoMaria != null) {
        val entrega = Entrega(pedidoMaria)
        println("--- Acompanhando a entrega ---")
        repeat(4) { entrega.avancarStatus() }   // o 4º avanço mostra que já terminou
        entrega.cancelar()                      // não pode cancelar um pedido entregue
    }
}
