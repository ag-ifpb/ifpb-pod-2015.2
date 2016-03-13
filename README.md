# ifpb-pod-2015.2
Implementações para as soluções propostas nas atividades de POD do IFPB-CZ


## projeto p1-*
Este projeto apresenta uma solução possível para um problema de garantia de transmissão e 
recepção de mensagens referente ao uma requisição.

Atendendo a idéia de componentes autônomos, cada nó possui dois componentes, 
sendo que entre eles (mesmo nó) a comunicação é baseada em dados compartilhados. 
Já entre os nós a comunicação é síncrona e assume uma simples estrutura de cliente-servidor.

Apesar desta solução ser viável para determinados cenários, faz-se necessário ainda
modificações para que atenda a alguns requisitos de qualidade:
- confiabilidade: até onde este sistema pode atender sem quebrar?
- concorrência: supondo um tempo de processamente de 10s, qual a quantidade de 
requisições ele suporta e como garantir que a resposta Y é pertencente a uma requisição X?
- escalabilidade: como fazer para aumentar o limite do número de requisições?

## projeto p2-*
TODO
