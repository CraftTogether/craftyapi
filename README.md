# CraftyAPI (Craft Together API)
CraftyAPI is a plugin which serves data over a REST API, it allows other users to be able to fetch data
from CraftTogether with a simple and easy to use API.

# Endpoints

### `/api/global/blocks-broken`
Gets the total number of blocks broken on the server
#### Example response:
```json
{
  "user": "global",
  "blocksBroken": 28
}
```
**WARNING** the user will always be global, this is due to the same object being used
for user dependant statistics