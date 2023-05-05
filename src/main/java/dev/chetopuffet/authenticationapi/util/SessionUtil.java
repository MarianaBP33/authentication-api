package dev.chetopuffet.authenticationapi.util;

import java.util.UUID;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import dev.chetopuffet.authenticationapi.model.AbstractModificationAttributesEntity;
import dev.chetopuffet.authenticationapi.model.User;

@Component
public class SessionUtil {
  public UUID getLoggedUserId() {
    var context = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return context.getId();
  }

  public void setCreatedBy(AbstractModificationAttributesEntity entity) {
    entity.setCreatedBy(getLoggedUserId());
  }

  public void setUpdatedBy(AbstractModificationAttributesEntity entity) {
    entity.setUpdatedBy(getLoggedUserId());
  }
}
