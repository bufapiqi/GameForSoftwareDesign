package Skills;
/**
 *
 * 技能的基类
 *
 * */
public class Skill {
    protected String skill_name;
    protected int skill_proficiency;
    public Skill(String skill_name){
        this.skill_name = skill_name;
        this.skill_proficiency = 0;
    }

    public void self_add_proficiency(){
        skill_proficiency++;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public int getSkill_proficiency() {
        return skill_proficiency;
    }
}
