lombok

run socket (will instance the SimpMessageSendingOperations)
run uiHandlerService (it needs the socket, will instance the db & the ServicesMediator)
run restService (it needs the ServicesMediator, will start also swagger)
run the socket client
http://localhost:8080/swagger-ui.html

