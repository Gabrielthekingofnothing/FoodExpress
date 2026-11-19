// Regras de cálculo do valor da compra
object Pagamento {
    const val TAXA_ENTREGA = 7.5
    const val FRETE_GRATIS_A_PARTIR = 150.0
    const val DESCONTO_A_PARTIR = 100.0
    const val PERCENTUAL_DESCONTO = 10.0

    // 10% de desconto para compras a partir de R$ 100,00
    fun calcularDesconto(subtotal: Double): Double =
        if (subtotal >= DESCONTO_A_PARTIR) subtotal * PERCENTUAL_DESCONTO / 100 else 0.0

    // Frete grátis para compras a partir de R$ 150,00
    fun calcularTaxaEntrega(subtotal: Double): Double =
        if (subtotal >= FRETE_GRATIS_A_PARTIR) 0.0 else TAXA_ENTREGA
}
