package entity.player.weapon;

public enum WeaponType {
	/**
	 * 1-shot, moderate firerate, moderate damage, moderate range, fast reload
	 */
	Pistol,
	/** Multi-shot, moderate firerate, high damage, short range, slow reload */
	Shotgun,
	/**
	 * 1-shot, slow fireRate, high damage, long range, can pierce line, slow
	 * reload
	 */
	Sniper,
	/** Multi-shot, fast firerate, low damage, moderate range, fast reload */
	Assault,
	/**
	 * 2 phase mechanic, slow firerate, burst damage, medium range, moderate
	 * reload
	 */
	CornerShot;
	/** The time between shots. */
	double fireRate;
	/** The time before a reload is */
	double reloadTime;
	/** How far a projectile for this weapon can go. */
	double range;
	/** Damage dealt to other entities. */
	int damage;
	/** The amount of projectiles available before reloading. */
	int bullets;
	/** Weight of the gun. Affects movement speed. */
	double weight;

}
