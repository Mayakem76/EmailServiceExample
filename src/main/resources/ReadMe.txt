Scrivi un'applicazione Spring Boot con le dipendenze necessarie che:
ha tutta la configurazione SMTP e-mail necessaria inapplication.yml
definisce un'entità Student con le seguenti proprietà di stringa:
id
name
surname
email

Student Service:
- getStudentById()  restituisce Students e è presente nell'elenco

Notification Controller
- espone sotto la mappatura notification:
    -un endpoint per l'invio di un'e-mail a uno specifico Student
    utilizzato  try/catch nel controller dedicato
    -se l'ID di Student è già nell'elenco, invia l'e-mail a quell'utente
    in caso contrario, risponde con un BAD_REQUEST
    -se la richiesta non è corretta, risponde con un errore 500 HTTP

NotificationDTO che consiste delle seguenti stringhe:
-contactId
-title
-text

Email Service:
    invia una email semplice ("/sms")

Email Service With HtmlText:
    invia un'e-mail con un messaggio HTML:
    utilizza MimeMessagee, tag HTML <h1>, <h2>, <img>e<h3>
    inserisce un'immagine dal web che ti piace
    all'interno del <h3>tag inserisce  text proveniente dalla bodyRequest

testato l'endpoint con Postman:
inviare email ad un utente presente nell'elenco (tu!)
prova a inviare email a un utente che non è presente nell'elenco
prova a inviare e-mail con un payload errato
dovresti ricevere un'email come quella mostrata nella foto email-received.PNG
