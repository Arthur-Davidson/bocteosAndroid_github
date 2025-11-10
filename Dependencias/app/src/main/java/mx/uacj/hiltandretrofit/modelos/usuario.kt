package mx.uacj.hiltandretrofit.modelos

data class Direccion(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String
)

data class Compania(
    val name: String,
    val catchPhrase: String,
    val bs: String
)

data class Usuario(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Direccion,
    val phone: String,
    val website: String,
    val company: Compania
)
