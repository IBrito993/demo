package com.ibrito.practice.demo.utils;



import com.ibrito.practice.demo.exception.BadRequestException;
import com.ibrito.practice.demo.exception.ConflictException;
import com.ibrito.practice.demo.exception.NotFoundException;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class Util {

  public static ModelMapper getStrictMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

    return modelMapper;
  }

  public static Pageable getPageable(Long page, Long size, String... sortName) {

    Pageable pageable;

    if (page == null || size == null) {
      pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(sortName).ascending());
    } else {
      pageable = PageRequest.of(page.intValue(), size.intValue(), Sort.by(sortName).ascending());
    }
    return pageable;
  }


  public static float getTotal(float price, float discount) {
    return price - (price * discount) / 100L;
  }

  public static void verifyForBadRequest(boolean condition, String message)
          throws BadRequestException {
    if (condition) {
      throw new BadRequestException(message);
    }
  }

  public static void verifyForNotFound(boolean condition, String message)
          throws NotFoundException {
    if (condition) {
      throw new NotFoundException(message);
    }
  }

  public static void verifyForConflict(boolean condition, String message)
          throws ConflictException {
    if (condition) {
      throw new ConflictException(message);
    }
  }
}
