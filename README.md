# TASK: SimpleDateFormat

Uruchamianie
```
mvn compile exec:java
```
Program pokazuje, że SimpleDateFormat nie jest thread safety. Aby zapewnić thread safety używam zmiennej ThreadLocal. Dzięki temu, każdy wątek będzie miał swoją instancje objektu. Nie jest potrzebna synchronizacja.
