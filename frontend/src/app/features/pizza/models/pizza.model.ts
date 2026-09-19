import { Ingredient } from './ingredient.model';
import { Allergen } from './allergen';

export default interface Pizza {
  id: number;
  name: string;
  price: number;
  imageUrl: string;
  ingredients: Ingredient[];
  allergens: Allergen[];
}
