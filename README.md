[![Release](https://img.shields.io/github/release/Blackoutburst/Super-Seat.svg)](https://github.com/Blackoutburst/Super-Seat/releases)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/79c2acb7bcca49efb5e6de1e680aa29b)](https://www.codacy.com/gh/Blackoutburst/Super-Seat/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Blackoutburst/Super-Seat&amp;utm_campaign=Badge_Grade)
# Super-Seat
Super Seat is a spigot plugin made in 1.16.5 to create seat using a special tool.

### Commands
`/seatwand` give you the seat wand ussed to create, remove and edit seats.\
`/reload` reload the configuration file.

### Configuration
`particle-render-distance` Tell how far the plugin should render seat particles when you hold the seat wand.\
`seat-height` Set the player height when he sit on a seat.

### Permission
`superseat.seatwand` give player access to the command `/seatwand`.\
`superseat.reload` give player access to the command `/reload`.

### Issue
Possible issue if player doesn't have the permission to interact with block (spawn protection / world guard) they will not be able to sit

## Usage
Use `/seatwand` to get the seat wand tool.\

With the wand :\
`RIGHT CLICK` a block to create a seat (works on **ANYTHING**)\
`RIGHT CLICK` a seat to remove a seat\
`LEFT CLICK` to change a seat orientation

Without the wand:\
`RIGHT CLICK` a seat to sit\
`DESTROY` a seat block to remove the seat

Right click a block to define a seat, when you create a new seat a green box of particle should appaer around the new\
![create](/readme/create.png)

Right click a seat with the wand to delete it, a red/orange box of particle should appaer around the deleted seat\
![remove](/readme/remove.png)

While holind the seatwand, players are able to see seat and the seat orientation\
Seat are define by a orange box and the seat orientation is defined by a blue line on top of this block\
![seat](/readme/seat.png)

Note : Last seat orientation is saved so when you create a new seat it will use the last orientation used making creation of long bench easier

## Screenshot
While holding the wand\
![exemple](/readme/exemple.png)

While sitting (using default seat height)\
![exemple](/readme/exemple2.png)
