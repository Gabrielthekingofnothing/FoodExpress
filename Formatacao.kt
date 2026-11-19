import java.util.Locale

// Função de extensão: transforma um Double em texto de dinheiro (ex: R$ 12,50)
fun Double.paraReais(): String =
    "R$ " + String.format(Locale.forLanguageTag("pt-BR"), "%.2f", this)
