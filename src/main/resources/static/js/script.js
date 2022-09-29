buttonAdd = document.getElementsByName("buttonAdd")
nome = document.getElementById("nome")
codigo = document.getElementById("cod")
preco = document.getElementById("preco")
subtotal = document.getElementById("subtotal")
qtd = document.getElementById("qtd")
closeButton = document.getElementById("closeButton")
closeXButton = document.getElementById("closeXButton")
confirmButton = document.getElementById("confirmButton")
valorPageProduct = document.getElementsByClassName("valor")

buttonAdd.forEach((button) => {
    button.onclick = () => {
        dados = button.parentNode.parentNode.getElementsByTagName("td")

        qtd.value = 1
        //codigo.parentElement.replaceChild(createElementP(dados[0].firstChild.nodeValue), codigo.nextElementSibling)
        codigo.getElementsByTagName("input")[0].value = dados[0].firstChild.nodeValue
        //nome.parentElement.replaceChild(createElementP(dados[1].firstChild.nodeValue), nome.nextElementSibling)
        nome.getElementsByTagName("input")[0].value = dados[1].firstChild.nodeValue
        //preco.parentElement.replaceChild(createElementP("R$" + dados[2].lastChild.nodeValue), preco.nextElementSibling)
        preco.getElementsByTagName("input")[0].value = dados[2].lastChild.nodeValue
        subtotal.parentElement.replaceChild(createElementP("R$" + dados[2].lastChild.nodeValue), subtotal.nextElementSibling)
    }
})

qtd.onchange = () => {
    var newValue = qtd.value * preco.getElementsByTagName("input")[0].value
    subtotal.parentElement.replaceChild(createElementP("R$" + newValue), subtotal.nextElementSibling)
}

function createElementP(text) {
    p = document.createElement("p")
    textAux = document.createTextNode(text)
    p.appendChild(textAux)
    return p
}

function brl() {
    for (const iterator of valorPageProduct) {
        iterator.insertBefore(document.createTextNode("R$"), iterator.firstChild)
    }
}
brl()