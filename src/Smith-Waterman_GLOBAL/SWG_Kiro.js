/**
 * Algoritmo Smith-Waterman de Alinhamento Global (Needleman-Wunsch)
 * Aluno: KIRO MARCELL DE ALMEIDA MENESES ARAÚJO
 * Número da chamada: 14
 * Disciplina; Bioinformática 2020.1
 */

function main() {
    var str1 = 'AGUGCUCUGCUGCCGAUACUGGACUUGGGCGGCGCAGGUUAGCCCUGGAAAAUGCCAACACAUUGGUCCAGUGCCCGAGGCCCCCCAGAGUCUUAGCAAUACAAGUUUAUCGGAUAGGAAAGGGACGAGACGAAGUGAAGAGAAUACUUGAGCCCCAAACCAACAAGGGUGUCAUAUCGGUUUCGUCCCAGUCUCGAAUC'
        , str2 = 'AGUUGAGUGCUGCCGAUACUGGACUUGGGCGGCGCAGGUUAAAUUAGCCCUGGAAAAUGCCAACACAUUGGUCCAGUGCCCGUCCCGAGGCCCCCCAGAGUCUUAGCAAGUUUAUCGGAUAGGAAAGGGACGA'
    /**RECOMENDO utilizar estas variáveis para visualizar um exemplo menor, mais fácil de observar no Terminal
     * basta descomentar as variáveis seguintes e comentar (//) as anteriores
     */
    //var str1 = 'CGTUCA'
    //var str2 = 'CATG'
    var match = 3, gap = -2, mismatch = -1
    var matriz = preencher_strings_na_matriz(str1, str2)
    var alinhamento_global = fazer_alinhamento(matriz, str1, str2, match, gap, mismatch)
    var valor_alinhamento = backtrack(alinhamento_global, str1, str2, match, gap, mismatch)
    var score = alinhamento_global[0][str2.length + 1]
    console.log(alinhamento_global, '\nAlinhamento: ', valor_alinhamento, '\nScore: ', score)
} main()

function preencher_strings_na_matriz(str1, str2) {
    var matriz = matriz = Array(str1.length + 2).fill().map(() => Array(str2.length + 2).fill())
    var j = 0
    //preenchendo a string 1 na primeira coluna
    for (var i = str1.length - 1; i >= 0; i--) {
        matriz[i][0] = str1[j]
        j++
    }
    j = str2.length - 1
    //preenchendo a string 2 na segunda coluna
    for (var i = str2.length + 1; i > 1; i--) {
        matriz[str1.length + 1][i] = str2[j]
        j--
    }
    //colocando 'null' em todos os 'undefined'
    for (let i = 0; i < matriz.length; i++) {
        for (let j = 0; j < matriz[i].length; j++) {
            if (matriz[i][j] == undefined)
                matriz[i][j] = null
        }
    }

    matriz[str1.length][1] = 0
    return matriz
}

function fazer_alinhamento(matriz, str1, str2, match, gap, mismatch) {

    for (let i = str1.length; i >= 0; i--) {
        for (let j = 1; j < str2.length + 2; j++) {
            //primeira linha horizontal comparando com o gap
            if (matriz[str1.length][0] == null && matriz[i][j] != 0) {
                matriz[i][j] = matriz[i][j - 1] + gap
            }
            //primeira linha vertical comparando com o gap
            if (matriz[str1.length + 1][1] == null && matriz[i][j] != 0 && isNaN(matriz[i][j]) == true) {
                matriz[i][j] = matriz[i + 1][j] + gap
            }
        }
    }
    //fazendo o alinhamento em si e guardando o backtrack
    for (let i = str1.length - 1; i >= 0; i--) { // for que percorre somente as células que faltam comparar
        for (let j = 2; j < matriz[i].length; j++) {
            var a, b, c, valor_max
            a = matriz[i][j - 1] + gap
            c = matriz[i + 1][j] + gap
            if (matriz[i][0] != matriz[str1.length + 1][j]) {
                b = matriz[i + 1][j - 1] + mismatch
            } else if (matriz[i][0] == matriz[str1.length + 1][j]) {
                b = matriz[i + 1][j - 1] + match
            }
            console.log('Comparando', matriz[i][0], matriz[str1.length + 1][j], '(', a, b, c, ')')//Score local de cada comparação (em trios)
            valor_max = Math.max(a, b, c)
            matriz[i][j] = valor_max
        }
    }
    return matriz
}

function backtrack(matriz, str1, str2, match, gap, mismatch) {
    var val_alinhamento = matriz[0][str2.length + 1]
    let i = 0, j = str2.length + 1
    while (1) {
        var a, b, c, valor_max
        a = matriz[i][j - 1] + gap
        c = matriz[i + 1][j] + gap
        if (matriz[i][0] != matriz[str1.length + 1][j]) {
            b = matriz[i + 1][j - 1] + mismatch
        } else if (matriz[i][0] == matriz[str1.length + 1][j]) {
            b = matriz[i + 1][j - 1] + match
        }
        valor_max = Math.max(a, b, c)
        if (valor_max == a) {
            val_alinhamento += matriz[i][j - 1]
            j--
        } if (valor_max == b) {
            val_alinhamento += matriz[i + 1][j - 1]
            i++
            j--
        } if (valor_max == c) {
            val_alinhamento += matriz[i + 1][j]
            i++
        } if (i + 1 == 5 || j - 1 == 0)
            return val_alinhamento
    }
}
