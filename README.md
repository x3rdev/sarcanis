# Sarcanis

*Working title: WFT (Weird Fleshy Things)*

A mod about various living things made of a twisted mix of flesh, bones and sinews.

## Resources

- [x] Bone needle
- [x] Bone shard
- [x] Infected flesh
- [x] Twisted bone
- [x] Sinew strand
- [x] Mucous membrane
- [x] Sharp bone
- [x] Glial mass
- [x] Symbiotic tumor
- [x] Twitching leg
- [x] Amorphous flesh

## Items

- [x] **Bone syringe** — main mod tool. Draws up liquids (player's blood, Ichor) and injects them into something, including the player.
- [x] **Centipede greatsword** — melee weapon
- [x] **Flesh halberd** — melee weapon
- [x] **Flesh lance** — melee weapon
- [x] **Flesh guitar** — ranged weapon; only works paired with Living amplifiers (up to two)
- [x] **Bio-cannon** — ranged weapon shooting bioplasma clots
- [ ] **Flesh shield**
- [ ] **Flesh armor** — armor made of flesh and bones
- [ ] **Amniotic backpack** — lets the player store gear during long travels

## Liquids

- [ ] **Ichor** — non-transparent yellow liquid. Extremely dangerous: damages the player and may infect them.
- [ ] **Nutrient broth** — purified Ichor. Used for growing and storing living organisms (living flesh gear, mobs, plants).

## Plants

- [ ] **Hemovine** — bears fruit containing Amorphous flesh (meat analogue; can fuel the mod's blocks or be cooked and eaten)
- [ ] **Ichor bloom** — bears fruit with jelly sacs of Ichor
  - [ ] Fruits craft into Mucous membrane, which crafts into Membrane block
  - [ ] Can be used to cultivate specific virus strains

## Blocks / Multiblocks

- [ ] **Purifier** — living block turning Ichor into Nutrient broth. Fueled with meat or Amorphous flesh (like coal in a furnace).
- [ ] **Bone cauldron** — produces Ichor by combining water and Infected flesh over time
- [ ] **Recycler** — multiblock shredder that recycles Malformed mass, Mancubus corpse, flesh gear and dead flesh gear into random fleshy resources
- [ ] **Amniotic container** — Nutrient broth storage
- [ ] **Amniotic chamber** — the mod's main multiblock (3x3x5, flesh blocks + membrane blocks). Grows fleshy living gear (weapons, armor, etc.) and some mobs.
  - [ ] Fill with Nutrient broth and throw in the resources matching an item's recipe
  - [ ] Wrong resource combination fails the growth and produces **Malformed mass**
  - [ ] Malformed mass can be recycled for Symbiotic tumor, or used to identify and test virus strains
  - [ ] Filling the chamber with Ichor instead of Nutrient broth destroys it
  - [ ] Nutrient broth must be renewed every 3 crafts, otherwise growth fails
- [ ] **Fleshy pipe** — transfers Nutrient broth
- [ ] **Fleshy valve** — controls Nutrient broth flow
- [ ] **Fleshy pump** — pumps Nutrient broth through fleshy pipes. Powered by redstone. Occasionally steals a bit of Nutrient broth.
- [ ] **Amniotic chest** — stores fleshy gear; must be filled with Nutrient broth
- [ ] **Fleshy door**
- [ ] **Bone block**
- [ ] **Flesh block**
- [x] **Membrane block**

## Mobs

> Mob names are WIP — current names are placeholders.

- [x] **Infected** — slow, stupid zombie-like mob. Found in groups of 3–4.
- [x] **Flying bug** — big flying bug that sneaks up and grabs a player or an Infected
  - Grabbed Infected are controlled by the Bug; the Bug can't be killed while its Infected is alive
  - A grabbed player takes damage every tick until death; can break free by pressing Shift repeatedly
- [x] **Bacteriophage** — defenseless on its own, but takes control of nearby zombies, making them faster, stronger and smarter and forcing them to protect it. Its Ichor contains a unique virus strain that can be turned into Rage mixture.
- [x] **Big fleshy T-rex**
- [ ] **Mancubus-like mob** — two bio-plasma cannons instead of arms. Its corpse can be healed in the Amniotic chamber and used as weaponized armor.
- [ ] **Big bird-like creature** with multiple bio-plasma cannons
- [ ] **Big armored worm** — bone armor plates on its segments must be broken before it can be damaged
- [ ] **Quadrupedal monster**
- [ ] **Giant kaiju monster**
- [ ] **Meat golem** — artificially grown mob
- [x] **Living amplifier** — artificially grown mob paired with the Flesh guitar. Shoots sound waves while the player plays the guitar. Up to two at a time.

## Rage

- [ ] **Rage mixture** — made from the Bacteriophage's virus strain; injected into the player to put all equipment into Rage mode
- [ ] Rage mode makes equipment stronger, but uncontrolled enraged equipment can damage or kill the user
- [ ] **Rage bar** HUD — filled by successful attacks
- [ ] At high Rage levels the player takes damage every few ticks
- [ ] Player dies if the bar reaches 100%

## Infection

- [ ] Infection sources:
  - [ ] Mob attacks (very low chance)
  - [ ] Contact with Ichor liquid (100%)
  - [ ] Injecting Ichor into self with the syringe (100%)
  - [ ] Eating Ichor fruit (100%)
- [ ] 4 stages, progressing over time; each stage grants buffs and debuffs
- [ ] Stage 4 kills the player and deletes their loot (no drop)
- [ ] **Weak antidote** — cures stage 1; on stages 2–3 only halts spread
- [ ] **Strong antidote** — cures stages 1–3; stage 4 is incurable

## Virus Strains

- [ ] Collect Ichor with the syringe from different sources (mobs, Ichor lakes, plants); each source carries different strains
- [ ] Inject strains into the Amniotic chamber during gear growth to modify the gear
- [ ] Identify a strain's type by using it on Malformed mass
- [ ] Replicate a strain by injecting Ichor into a fruitless Ichor bloom
- [ ] Strain types:
  - [ ] **Unstable** — destroyed by the gear's immune system; no effect
  - [ ] **Balanced** — balanced bonuses and drawbacks
  - [ ] **Dangerous** — strong bonuses and drawbacks
  - [ ] **Deadly** — destroys the gear
  - [ ] **Unique** — unique modifications for specific gear types

## Fleshy Gear Durability

- [ ] All fleshy gear has high durability, which slowly decays outside an Amniotic chest or Amniotic backpack
- [ ] Durability regenerates while stored in one of those containers
- [ ] At 0 durability the gear dies and becomes an unrepairable dead gear item, recyclable only in the Recycler

## Viral Modifications (Flesh Armor Set)

- [ ] **Predator** — when damaged or near enemies, grows claws on the hands (more empty-hand damage) and spikes on the body (damages melee attackers)
- [ ] **Defender** — the more damage taken, the more armor grows; slowly heals the user
- [ ] **Steadfast** — slows Rage bar filling
- [ ] **Wild** — speeds up Rage bar filling
- [ ] **Centipede** — grows 2 segmented tails with sharp bone blades; long-range tail attacks, climbing, leaping
- [ ] **Serrated** — grows 5 hooked tails; short-range attacks that apply Bleed; tails can be used as a shield
- [ ] **Devourer** — grows 3 powerful toothed tails with mouths at the ends; grab, throw and bite entities and items
