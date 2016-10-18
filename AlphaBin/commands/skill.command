set vmname Skill-VM
set ip 10.230.20.21
set port 5003

register broadcastTransmiter com.gft.alpha.net.service.BroadcastTransmiterService
register broadcastReceiver com.gft.alpha.net.service.BroadcastReceiverService
register tcpserver com.gft.alpha.net.service.TCPServerService
register pulse com.gft.alpha.net.service.PulseService
register terminal com.gft.alpa.service.terminal.TerminalService

load ..\data\skill.txt

provide-service Q-SKILL-SERVICE com.gft.alpha.net.handler.QueryServiceHandler

start broadcastTransmiter 10.230.20.255 5000 5009 3000 SUBSCRIBE:S-PULSE-SERVICE:10.230.20.21:5003;
start broadcastTransmiter 10.230.20.255 5000 5009 3000 SUBSCRIBE:S-SEQUENCER-SERVICE:10.230.20.21:5003;
start broadcastReceiver 5003
start tcpserver 5003
start pulse 15000
start terminal 5103
