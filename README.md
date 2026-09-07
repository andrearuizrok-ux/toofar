# TOOFAR? — Friends Beta

Questa build è pensata per **provare davvero la Party Mode con amici su più telefoni**.

## Cosa funziona
- Primo avvio con intro, nickname e avatar
- Logo e launcher icon TOOFAR?
- Crea room / entra con codice
- Lobby sincronizzata tra telefoni
- Voto temi fino a 3
- Temi personalizzati
- Domande personalizzate della room
- Voto segreto 0–100
- Reveal simultaneo
- Debate Time con i due estremi
- Voto dell'argomento migliore
- Possibilità di cambiare idea
- Punti di round
- Chaos Report finale con titoli divertenti
- Condivisione nativa del codice room

## Tecnologia room
Per la beta, le room usano WebRTC peer-to-peer tramite Trystero/Nostr. Non serve creare account o un backend.
L'host deve restare connesso durante la partita. I dati della room sono temporanei.

## Test rapido
1. Installa lo stesso APK su almeno 2 telefoni Android.
2. Tutti devono avere Internet.
3. Sul primo telefono: Party → Crea room.
4. Condividi il codice.
5. Sugli altri: Party → Entra con codice.
6. Attendi che tutti compaiano in lobby.
7. L'host avvia la partita.

## Build GitHub
Carica il contenuto di questo progetto nella root del repository `toofar`.
GitHub Actions genera automaticamente l'artifact `TOOFAR-Friends-Beta-APK`.

> Questa è una beta per test privati, non una release Play Store. Per una versione pubblica serviranno backend/account persistenti, moderazione, privacy policy, analytics e firma release.
