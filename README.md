# TEMA 1
#### Aplicatia va fi dezvoltata la locatia X:\ppsd\tema1 si va contine urmatoarele fisiere:
* ServerMesagerie.java -- contine cel putin clasa ServerMesagerie
* informatiiServer.txt -- fisier de informatii si parametri pentru server
* Client.java -- contine cel putin clasa Client
* Clasa Client va primi la executie, in linia de comanda, parametrii numeClient si parolaClient 
#### In consola clientului vor trebui sa fie disponibile urmatoarele comenzi:
* signup -- folosita pentru inregistrarea unui client la server
* login -- folosita pentru autentificarea la server, inceperea unei sesiuni
* logout -- folosita pentru incheierea unei sesiuni la server
* getClientsList -- folosita pentru obtinerea de la server a listei de clienti inregistrati
* sendMessage -- folosita pentru trimiterea unui mesaj catre un client
* getMessages -- folosita pentru preluarea de la server a mesajelor primite de la alti clienti
### Restrictii:

* operatiile getClientsList / sendMessage / getMessages vor putea fi realizate doar daca clientul este autentificat
* operatia de login va fi realizata doar daca clientul este inregistrat
Fisierul informatiiServer.txt contine numarul maxim de conexiuni client care pot fi deschise simultan, si o lista cu utilizatorii inregistrati (nume si parola) pana la un anumit moment.

Clasa ServerMesagerie incarca la executie lista de utilizatori si numarul maxim de conexiuni client deschise simultan din fisierul informatiiServer.txt.

### Precizari si restrictii:

* serverul trebuie sa ofere posibilitatea conectarii simultane a mai multor clienti (sa fie multithread)
* la inregistrarea unui utilizator serverul actualizeaza si lista cu utilizatori inregistrati din fisierul informatiiServer.txt
* accesul la variabilele care pot fi accesate simultan de mai multi clienti (precum lista utilizatorilor, "memoria" in care se tin mesajele, numarul curent de clienti conectati, etc) trebuie sa se faca sincronizat
## IMPORTANT: Lucrurile nespecificate pot fi implementate in orice mod cu conditia respectarii cerintelor impuse in enunt.

