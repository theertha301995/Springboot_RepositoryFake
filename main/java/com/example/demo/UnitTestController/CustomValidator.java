//package com.example.demo.UnitTestController;
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//    public class CustomValidator implements ConstraintValidator<CustomValidation, String> {
//    	 
//        @Override
//        public void initialize(CustomValidation constraintAnnotation) {
//        }
//     
//        @Override
//        public boolean isValid(String age, ConstraintValidatorContext context) {
//       	 if (age == null) {
//                return false; // Handle null values as invalid
//            }
//     
//            String ageString = age.toString(); // Convert BigDecimal to String (preserves precision)
//     
//            // Split into parts, handling edge cases (empty string, single dot)
//            String[] parts = ageString.split("\\.");
//            if (parts.length < 1 || parts.length > 2) {
//                return false; // Invalid format if not 1 or 2 decimal parts
//            }
//     
//            int leftDecimal;
//            int rightDecimal = 0; // Initialize rightDecimal to 0 (handles cases with no decimal part)
//     
//            try {
//                leftDecimal = Integer.parseInt(parts[0]);
//                if (parts.length == 2) {
//                    rightDecimal = Integer.parseInt(parts[1]);
//                }
//            } catch (NumberFormatException e) {
//                return false; // Handle non-numeric values
//            }
//     
//            // Validate left decimal position (0-99)
//            if (leftDecimal < 0 || leftDecimal > 99) {
//                return false;
//            }
//            if (rightDecimal != 0) {
//                // Check if the fraction part starts with 0
//                if (parts[1].startsWith("0")) {
//                    return false;
//                }
//               
//            
//                // Validate right decimal position (1-12)
//                if (rightDecimal < 1 || rightDecimal > 12) {
//                    return false;
//                }
//            }
//                else  if(parts.length==2&& leftDecimal==0)
//                {
//                	return false;
//                }
//                
//            
//            return true;
//        }
//    }
//
//    