set vmname Role-VM
set ip 10.230.20.21
set port 5004
set terminalPort 5104

import common.command

load role.txt

provide-service Q-ROLE-SERVICE com.gft.alpha.net.handler.QueryServiceHandler
