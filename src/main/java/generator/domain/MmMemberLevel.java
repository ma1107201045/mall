package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 会员管理服务-会员等级表
 * @TableName mm_member_level
 */
@TableName(value ="mm_member_level")
public class MmMemberLevel implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private Long id;

    /**
     * 等级名称
     */
    private String name;

    /**
     * 增长点
     */
    private Integer growthPoint;

    /**
     * 每次评价获取的成长值
     */
    private Integer commentGrowthPoint;

    /**
     * 是否是默认等级 1是 0否
     */
    private Integer isDefaultLevel;

    /**
     * 是否有免邮特权
     */
    private Integer isPriviledgeFreeFreight;

    /**
     * 是否有签到特权
     */
    private Integer isPriviledgeSignIn;

    /**
     * 是否有评论获奖励特权
     */
    private Integer isPriviledgeComment;

    /**
     * 是否有专享活动特权
     */
    private Integer isPriviledgePromotion;

    /**
     * 是否有会员价格特权
     */
    private Integer isPriviledgeMemberPrice;

    /**
     * 是否有生日特权
     */
    private Integer isPriviledgeBirthday;

    /**
     * 免运费标准
     */
    private BigDecimal freeFreightPoint;

    /**
     * 备注
     */
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 等级名称
     */
    public String getName() {
        return name;
    }

    /**
     * 等级名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 增长点
     */
    public Integer getGrowthPoint() {
        return growthPoint;
    }

    /**
     * 增长点
     */
    public void setGrowthPoint(Integer growthPoint) {
        this.growthPoint = growthPoint;
    }

    /**
     * 每次评价获取的成长值
     */
    public Integer getCommentGrowthPoint() {
        return commentGrowthPoint;
    }

    /**
     * 每次评价获取的成长值
     */
    public void setCommentGrowthPoint(Integer commentGrowthPoint) {
        this.commentGrowthPoint = commentGrowthPoint;
    }

    /**
     * 是否是默认等级 1是 0否
     */
    public Integer getIsDefaultLevel() {
        return isDefaultLevel;
    }

    /**
     * 是否是默认等级 1是 0否
     */
    public void setIsDefaultLevel(Integer isDefaultLevel) {
        this.isDefaultLevel = isDefaultLevel;
    }

    /**
     * 是否有免邮特权
     */
    public Integer getIsPriviledgeFreeFreight() {
        return isPriviledgeFreeFreight;
    }

    /**
     * 是否有免邮特权
     */
    public void setIsPriviledgeFreeFreight(Integer isPriviledgeFreeFreight) {
        this.isPriviledgeFreeFreight = isPriviledgeFreeFreight;
    }

    /**
     * 是否有签到特权
     */
    public Integer getIsPriviledgeSignIn() {
        return isPriviledgeSignIn;
    }

    /**
     * 是否有签到特权
     */
    public void setIsPriviledgeSignIn(Integer isPriviledgeSignIn) {
        this.isPriviledgeSignIn = isPriviledgeSignIn;
    }

    /**
     * 是否有评论获奖励特权
     */
    public Integer getIsPriviledgeComment() {
        return isPriviledgeComment;
    }

    /**
     * 是否有评论获奖励特权
     */
    public void setIsPriviledgeComment(Integer isPriviledgeComment) {
        this.isPriviledgeComment = isPriviledgeComment;
    }

    /**
     * 是否有专享活动特权
     */
    public Integer getIsPriviledgePromotion() {
        return isPriviledgePromotion;
    }

    /**
     * 是否有专享活动特权
     */
    public void setIsPriviledgePromotion(Integer isPriviledgePromotion) {
        this.isPriviledgePromotion = isPriviledgePromotion;
    }

    /**
     * 是否有会员价格特权
     */
    public Integer getIsPriviledgeMemberPrice() {
        return isPriviledgeMemberPrice;
    }

    /**
     * 是否有会员价格特权
     */
    public void setIsPriviledgeMemberPrice(Integer isPriviledgeMemberPrice) {
        this.isPriviledgeMemberPrice = isPriviledgeMemberPrice;
    }

    /**
     * 是否有生日特权
     */
    public Integer getIsPriviledgeBirthday() {
        return isPriviledgeBirthday;
    }

    /**
     * 是否有生日特权
     */
    public void setIsPriviledgeBirthday(Integer isPriviledgeBirthday) {
        this.isPriviledgeBirthday = isPriviledgeBirthday;
    }

    /**
     * 免运费标准
     */
    public BigDecimal getFreeFreightPoint() {
        return freeFreightPoint;
    }

    /**
     * 免运费标准
     */
    public void setFreeFreightPoint(BigDecimal freeFreightPoint) {
        this.freeFreightPoint = freeFreightPoint;
    }

    /**
     * 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MmMemberLevel other = (MmMemberLevel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGrowthPoint() == null ? other.getGrowthPoint() == null : this.getGrowthPoint().equals(other.getGrowthPoint()))
            && (this.getCommentGrowthPoint() == null ? other.getCommentGrowthPoint() == null : this.getCommentGrowthPoint().equals(other.getCommentGrowthPoint()))
            && (this.getIsDefaultLevel() == null ? other.getIsDefaultLevel() == null : this.getIsDefaultLevel().equals(other.getIsDefaultLevel()))
            && (this.getIsPriviledgeFreeFreight() == null ? other.getIsPriviledgeFreeFreight() == null : this.getIsPriviledgeFreeFreight().equals(other.getIsPriviledgeFreeFreight()))
            && (this.getIsPriviledgeSignIn() == null ? other.getIsPriviledgeSignIn() == null : this.getIsPriviledgeSignIn().equals(other.getIsPriviledgeSignIn()))
            && (this.getIsPriviledgeComment() == null ? other.getIsPriviledgeComment() == null : this.getIsPriviledgeComment().equals(other.getIsPriviledgeComment()))
            && (this.getIsPriviledgePromotion() == null ? other.getIsPriviledgePromotion() == null : this.getIsPriviledgePromotion().equals(other.getIsPriviledgePromotion()))
            && (this.getIsPriviledgeMemberPrice() == null ? other.getIsPriviledgeMemberPrice() == null : this.getIsPriviledgeMemberPrice().equals(other.getIsPriviledgeMemberPrice()))
            && (this.getIsPriviledgeBirthday() == null ? other.getIsPriviledgeBirthday() == null : this.getIsPriviledgeBirthday().equals(other.getIsPriviledgeBirthday()))
            && (this.getFreeFreightPoint() == null ? other.getFreeFreightPoint() == null : this.getFreeFreightPoint().equals(other.getFreeFreightPoint()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGrowthPoint() == null) ? 0 : getGrowthPoint().hashCode());
        result = prime * result + ((getCommentGrowthPoint() == null) ? 0 : getCommentGrowthPoint().hashCode());
        result = prime * result + ((getIsDefaultLevel() == null) ? 0 : getIsDefaultLevel().hashCode());
        result = prime * result + ((getIsPriviledgeFreeFreight() == null) ? 0 : getIsPriviledgeFreeFreight().hashCode());
        result = prime * result + ((getIsPriviledgeSignIn() == null) ? 0 : getIsPriviledgeSignIn().hashCode());
        result = prime * result + ((getIsPriviledgeComment() == null) ? 0 : getIsPriviledgeComment().hashCode());
        result = prime * result + ((getIsPriviledgePromotion() == null) ? 0 : getIsPriviledgePromotion().hashCode());
        result = prime * result + ((getIsPriviledgeMemberPrice() == null) ? 0 : getIsPriviledgeMemberPrice().hashCode());
        result = prime * result + ((getIsPriviledgeBirthday() == null) ? 0 : getIsPriviledgeBirthday().hashCode());
        result = prime * result + ((getFreeFreightPoint() == null) ? 0 : getFreeFreightPoint().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", growthPoint=").append(growthPoint);
        sb.append(", commentGrowthPoint=").append(commentGrowthPoint);
        sb.append(", isDefaultLevel=").append(isDefaultLevel);
        sb.append(", isPriviledgeFreeFreight=").append(isPriviledgeFreeFreight);
        sb.append(", isPriviledgeSignIn=").append(isPriviledgeSignIn);
        sb.append(", isPriviledgeComment=").append(isPriviledgeComment);
        sb.append(", isPriviledgePromotion=").append(isPriviledgePromotion);
        sb.append(", isPriviledgeMemberPrice=").append(isPriviledgeMemberPrice);
        sb.append(", isPriviledgeBirthday=").append(isPriviledgeBirthday);
        sb.append(", freeFreightPoint=").append(freeFreightPoint);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}