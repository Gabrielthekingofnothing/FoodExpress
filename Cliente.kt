// Representa um cliente cadastrado.
// O endereço é String? (pode ser nulo): é aqui que usamos Null Safety.
class Cliente(
    val nome: String,
    val telefone: String,
    val endereco: String? = null
) {
    // Verifica se o endereço existe e não está em branco
    fun temEnderecoValido(): Boolean = !endereco.isNullOrBlank()

    // Operador elvis (?:): se endereco for nulo, usa o texto padrão
    fun enderecoParaEntrega(): String = endereco ?: "Endereço não informado"
}
