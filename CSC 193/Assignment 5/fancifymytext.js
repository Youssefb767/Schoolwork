// Youssef Boujebha 11/19/2025
function makeBigger() {
    alert("Hello, world!");
    document.getElementById("textArea").style.fontSize = "24pt";
}

function fancyShmancy() {
    const textArea = document.getElementById("textArea");
    textArea.style.fontWeight = "bold";
    textArea.style.color = "blue";
    textArea.style.textDecoration = "underline";
}

function boringBetty() {
    const textArea = document.getElementById("textArea");
    textArea.style.fontWeight = "normal";
    textArea.style.color = "black";
    textArea.style.textDecoration = "none";
}

function mooify() {
    const textArea = document.getElementById("textArea");
    let text = textArea.value.toUpperCase();

    // Split the text by periods into sentences
    let sentences = text.split(".");

    // Add "-Moo" to each non-empty sentence
    for (let i = 0; i < sentences.length; i++) {
        let sentence = sentences[i].trim();
        if (sentence.length > 0) {
            sentences[i] = sentence + "-Moo";
        }
    }

    // Join sentences back together with ". "
    textArea.value = sentences.join(". ");
}
