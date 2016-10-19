set vmname Team-VM
set ip 10.230.20.21
set port 5002
set terminalPort 5102

import common.command

load team.txt

provide-service Q-TEAM-SERVICE com.gft.alpha.net.handler.QueryServiceHandler

