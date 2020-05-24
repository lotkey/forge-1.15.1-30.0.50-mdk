package com.synthchris666.synthchrismod.entities;

import com.synthchris666.synthchrismod.init.ItemInitNew;
import com.synthchris666.synthchrismod.init.ModEntityTypes;
import com.synthchris666.synthchrismod.init.SoundInit;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ThiccenEntity extends AnimalEntity{
	public float wingRotation;
	public float destPos;
	public float oFlapSpeed;
	public float oFlap;
	public float wingRotDelta = 1.0F;
    
    private EatGrassGoal eatGrassGoal;
    private int thiccenTimer;

    public ThiccenEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        ThiccenEntity entity = new ThiccenEntity(ModEntityTypes.THICCEN_ENTITY.get(), this.world);
        entity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(entity)), SpawnReason.BREEDING, (ILivingEntityData)null, (CompoundNBT)null);
        return entity;
    }
    
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.eatGrassGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3,
                new TemptGoal(this, 1.1D, Ingredient.fromItems(ItemInitNew.CHERRIES.get()), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, this.eatGrassGoal);
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }
    
    @Override
    protected void updateAITasks() {
        this.thiccenTimer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }
    
    @Override
    public void livingTick() {
        if(this.world.isRemote) {
            this.arrowHitTimer = Math.max(0, thiccenTimer - 1);
        }
        super.livingTick();
        int randInt = (int) ((Math.random() * 100) % 40);
        if(randInt==0) {
        	EggEntity eggEntity = new EggEntity(this.world, this);
        	eggEntity.setRawPosition(this.getPosX(), this.getPosY() + 1, this.getPosZ());
            eggEntity.addVelocity(
    				(Math.cos((this.rotationYaw+90) * 0.0174533) * Math.cos((this.rotationPitch) * 0.0174533)) * 1.5, 
    				(Math.sin((this.rotationPitch+180) * 0.0174533)) * 1.5, 
    				(Math.sin((this.rotationYaw+90) * 0.0174533) * Math.cos((this.rotationPitch) * 0.0174533)) * 1.5);
            this.world.addEntity(eggEntity);
            this.oFlap = this.wingRotation;
  	      this.oFlapSpeed = this.destPos;
  	      this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);
  	      this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);
  	      if (!this.onGround && this.wingRotDelta < 1.0F) {
  	         this.wingRotDelta = 1.0F;
  	      }

  	      this.wingRotDelta = (float)((double)this.wingRotDelta * 0.9D);
  	      Vec3d vec3d = this.getMotion();
  	      if (!this.onGround && vec3d.y < 0.0D) {
  	         this.setMotion(vec3d.mul(1.0D, 0.6D, 1.0D));
  	      }

  	      this.wingRotation += this.wingRotDelta * 2.0F;
        }
    }

   protected SoundEvent getAmbientSound() {
      return SoundInit.ENTITY_THICCEN_AMBIENT.get();
   }

   protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
      return SoundInit.ENTITY_THICCEN_HURT.get();
   }

   protected SoundEvent getDeathSound() {
      return SoundInit.ENTITY_THICCEN_HURT.get();
   }
    
    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(.20d);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.thiccenTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationPointY(float p_70894_1_) {
        if (this.thiccenTimer <= 0) {
            return 0.0F;
        } else if (this.thiccenTimer >= 4 && this.thiccenTimer <= 36) {
            return 1.0F;
        } else {
            return this.thiccenTimer < 4 ? ((float) this.thiccenTimer - p_70894_1_) / 4.0F
                    : -((float) (this.thiccenTimer - 40) - p_70894_1_) / 4.0F;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadRotationAngleX(float p_70890_1_) {
        if (this.thiccenTimer > 4 && this.thiccenTimer <= 36) {
            float f = ((float) (this.thiccenTimer - 4) - p_70890_1_) / 32.0F;
            return ((float) Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.thiccenTimer > 0 ? ((float) Math.PI / 5F) : this.rotationPitch * ((float) Math.PI / 180F);
        }
    }
    
    private void launchEggToEntity(int num, LivingEntity entity) {
    	if(!(entity instanceof ChickenEntity)) {
    		this.launchEggToCoords(num, entity.getPosX(), entity.getPosY() + (double)entity.getEyeHeight() * 0.5D, entity.getPosZ(), num == 0 && this.rand.nextFloat() < 0.001F);
  	  	}
    }
    
    private void launchEggToCoords(int p_82209_1_, double x, double y, double z, boolean invulnerable) {
        //this.world.playEvent((PlayerEntity)null, 1024, new BlockPos(this), 0);
        double d0 = this.getPosX();
        double d1 = this.getPosY();
        double d2 = this.getPosZ();
        double d3 = x - d0;
        double d4 = y - d1;
        double d5 = z - d2;
        //WitherSkullEntity witherskullentity = new WitherSkullEntity(this.world, this, d3, d4, d5);
        EggEntity eggEntity = new EggEntity(this.world, this);

        eggEntity.setRawPosition(d0, d1, d2);
        eggEntity.addVelocity(
				(Math.cos((this.rotationYaw+90) * 0.0174533) * Math.cos((this.rotationPitch) * 0.0174533)) * 1.5, 
				(Math.sin((this.rotationPitch+180) * 0.0174533)), 
				(Math.sin((this.rotationYaw+90) * 0.0174533) * Math.cos((this.rotationPitch) * 0.0174533)) * 1.5);
        this.world.addEntity(eggEntity);
     }
    
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        this.launchEggToEntity(0, target);
     }
    
    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount) {
       if (this.isInvulnerableTo(source)) {
          return false;
       } else if (source != DamageSource.DROWN && !(source.getTrueSource() instanceof ThiccenEntity)) {
             Entity entity1 = source.getTrueSource();
             if (entity1 != null && !(entity1 instanceof PlayerEntity) && entity1 instanceof LivingEntity && ((LivingEntity)entity1).getCreatureAttribute() == this.getCreatureAttribute()) {
                return false;
             } else {
                return super.attackEntityFrom(source, amount);
             }
       } else {
          return false;
       }
    }
    
    protected boolean canBeRidden(Entity entityIn) {
        return true;
     }

    @Override
    public void onStruckByLightning(LightningBoltEntity lightningBolt) {
        this.setGlowing(true);
    }    
    
    @Override
    public boolean isBreedingItem(ItemStack stack) {
          return stack.getItem() == ItemInitNew.CHERRIES.get();
    }
    
    public void tick() {
		super.tick();
	}
    
    public boolean onLivingFall(float distance, float damageMultiplier) {
	      return false;
	}
}
