set vmname Monitor-VM
set ip 10.230.20.21
set port 5000
set terminalPort 5100

import common.command

provide-service S-PULSE-SERVICE com.gft.alpha.net.handler.PulseServiceHandler
provide-service Q-MONITOR-SERVICE com.gft.alpha.net.handler.MonitorQueryServiceHandler
