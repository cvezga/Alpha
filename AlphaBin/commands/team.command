set vmname Team-VM
set ip 10.230.20.21
set port 5002

register broadcastTransmiter com.gft.alpha.net.service.BroadcastTransmiterService
register broadcastReceiver com.gft.alpha.net.service.BroadcastReceiverService
register tcpserver com.gft.alpha.net.service.TCPServerService
register pulse com.gft.alpha.net.service.PulseService
register terminal com.gft.alpa.service.terminal.TerminalService

load ..\data\team.txt

provide-service Q-TEAM-SERVICE com.gft.alpha.net.handler.QueryServiceHandler

start broadcastTransmiter 10.230.20.255 5000 5009 3000 SUBSCRIBE:S-PULSE-SERVICE:10.230.20.21:5002;
start broadcastTransmiter 10.230.20.255 5000 5009 3000 SUBSCRIBE:S-SEQUENCER-SERVICE:10.230.20.21:5002;
start broadcastReceiver 5002
start tcpserver 5002
start pulse 15000
start terminal 5102
