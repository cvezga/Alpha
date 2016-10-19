set vmname Skill-VM
set ip 10.230.20.21
set port 5003
set terminalPort 5103

import common.command

load skill.txt

provide-service Q-SKILL-SERVICE com.gft.alpha.net.handler.QueryServiceHandler
