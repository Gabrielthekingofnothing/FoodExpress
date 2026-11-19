// Etapas possíveis de um pedido
enum class StatusPedido {
    RECEBIDO,
    EM_PREPARO,
    SAIU_PARA_ENTREGA,
    ENTREGUE,
    CANCELADO
}

// when como expressão: devolve um texto para cada status
fun StatusPedido.descricao(): String = when (this) {
    StatusPedido.RECEBIDO -> "Pedido recebido"
    StatusPedido.EM_PREPARO -> "Em preparo na cozinha"
    StatusPedido.SAIU_PARA_ENTREGA -> "Saiu para entrega"
    StatusPedido.ENTREGUE -> "Entregue"
    StatusPedido.CANCELADO -> "Cancelado"
}

// Próxima etapa do fluxo. Retorna null quando o pedido já terminou (Null Safety).
fun StatusPedido.proximo(): StatusPedido? = when (this) {
    StatusPedido.RECEBIDO -> StatusPedido.EM_PREPARO
    StatusPedido.EM_PREPARO -> StatusPedido.SAIU_PARA_ENTREGA
    StatusPedido.SAIU_PARA_ENTREGA -> StatusPedido.ENTREGUE
    StatusPedido.ENTREGUE, StatusPedido.CANCELADO -> null
}
