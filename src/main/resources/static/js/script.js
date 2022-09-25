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
        codigo.parentElement.replaceChild(createElementP(dados[0].firstChild.nodeValue), codigo.nextElementSibling)
        nome.parentElement.replaceChild(createElementP(dados[1].firstChild.nodeValue), nome.nextElementSibling)
        preco.parentElement.replaceChild(createElementP(dados[2].firstChild.nodeValue), preco.nextElementSibling)
        subtotal.parentElement.replaceChild(createElementP(dados[2].firstChild.nodeValue), subtotal.nextElementSibling)
    }
})

qtd.onchange = () => {
    var newValue = qtd.value * preco.nextElementSibling.firstChild.nodeValue
    subtotal.parentElement.replaceChild(createElementP(newValue), subtotal.nextElementSibling)
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