WHAT IS A BATTLE SYSTEM?
========================
  In terms of a game engine, a battle system is how a combat setting and its resolution is computed and then displayed
to the game-player. It is complex in its internals, but easy to understand in the basic aspects. For my implementation,
I break it down into the following parts: layout, method, enemy characters, and hero (player-controlled) characters.

The Battle Layout.
------------------
  The battle layout handles the screen placement and display where the main battle sequence is displayed to the player.
A layout may be expected to handle various screen transitions, effects, overlays, visual cues for action, -- basically,
anything that includes the graphical aspect. It may even be tasked with handling the battle sounds, for synchronization
and uniformity.

The Battle Method.
------------------
  The battle method handles the game methodology where turn resolution takes place. This is where battle mechanics are
defined and used. It requires handling what occurs before, during, and after the battle sequence; during the battle, it
also requires handling before, during, and after the turns (assuming a turn-based battle system).

The Battle Enemies.
-------------------
  The battle enemies list is the container object for the enemies that are being fought against by the hero party.

The Battle Heroes.
------------------
  The battle heroes list is the container object for the player's hero characters; these are the recruited heroes that
act according to how the player plays them.

Other Battle System Attributes.
-------------------------------
  Additionally, more battle system attributes may apply. Currently thinking about the battle conditions for win/loss...


HOW MANY BATTLE SYSTEMS EXIST?
==============================
  This section is meant to take on the question of, "how many battle systems exist?", and "which battle system is right
for my game?" This all depends upon a lot of factors.

  The most minimal battle system, beyond not having one at all (which may be a valid choice), is where the battle will
occur in the same game map; in other words, no interruption of ordinary game play. This requires specifying in your map
properties whether the battle system is on or off for the map.

  A battle system can be based upon how it is presented, or it can be about whether the methodology is turn-based or is
real-time action. Presentation can be visually appealing; but the latter choice is just as important. Turn-based battle
is quite ordered and linear in nature; unless the character list is sortable, we will always know they will act in the
order that they appear. Real-time battle is something altogether; this could be for the minimalist battle system that's
mentioned above, or it could be for a full-fledged battle system where characters may attack once they meet some basic
requirement -- such as ending the cool-down timer from the previous action, or making some kind of "initiative" check.

  A lot of the remaining battle systems are merely named for the visual perspective of the view, aside from the general
practical methodology, or "behind-the-scenes" mechanics; we may have top-down, or "tactical" battle systems; as well as
front-, rear-, side-, or quarter-view (diagonal) battle systems.

  In a front-facing layout, characters are facing the screen; our player-controlled characters may or may not even get
represented as an active sprite in the battle screen, perhaps only a panel in the character's status overlay.

  In a rear-facing layout, the hero characters appear in the foreground on the battle scene, as we are seeing them from
behind. This lends somewhat more realism, as we are presumed to be more than just an active spectator in the battle; we
may see things from our heroes' perspective (somewhat; after all, any battle system is a purely abstract encounter in a
game).

  In a side-facing layout, all characters are facing to one side or the other, lined up to a pattern, and sometimes in
more than one column. Heroes are on one side of the screen, facing the enemy; enemies are on the other side, facing the
heroes.

  In a quarter-turn layout, the perspective is that of looking at the battle from an obverse angle, such as a 30 to 45
degree offset from the linear axis crossing both troops. Using a compass analogy, it's about having the troops position
themselves at either a "northwest-southeast" or a "southwest-northeast" points on the screen; the line-of-sight between
the two should be diagonal across the screen.

In Summary.
-----------
  In general, for any of the above, a visual layout might include character-status overlays which give a brief glimpse
of the health or status of each playable character; enemies might or might not also have an overlay, or perhaps only an
actively-targeted enemy might show its basic statistics while being targeted.
