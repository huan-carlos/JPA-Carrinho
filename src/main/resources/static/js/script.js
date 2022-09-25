buttonAdd = document.getElementsByName("buttonAdd");
nome = document.getElementById("nome");
codigo = document.getElementById("cod");
preco = document.getElementById("preco");
subtotal = document.getElementById("subtotal");
qtd = document.getElementById("qtd");
reset = document.getElementById("reset");

buttonAdd.forEach((button) => {
    button.onclick = () => {
        dados = button.parentNode.parentNode.getElementsByTagName("td");
        codigo.append(dados[0].firstChild.nodeValue);
        nome.append(dados[1].firstChild.nodeValue);
        preco.append(dados[2].firstChild.nodeValue);
        subtotal.append(dados[2].firstChild.nodeValue);
    };
});

qtd.onchange = () => {
    subtotal.lastChild.nodeValue = qtd.value * preco.lastChild.nodeValue;
};

reset.onclick = () => {
    codigo.lastChild.remove();
    nome.lastChild.remove();
    preco.lastChild.remove();
    subtotal.lastChild.remove();
    qtd.value = 1;
};