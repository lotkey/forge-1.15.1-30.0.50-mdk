import PIL
from PIL import Image
import numpy as np

image_path = "egg_block - Copy.png"

def read_image(path):
    try:
        image = PIL.Image.open(path)
        return image
    except Exception as e:
        print(e)

def get_image_res(image):
    return image.size

def double_image(image):
    res = get_image_res(image)
    img_array = np.array(image)

    w, h = image.width, image.height;
    new_array = [[0 for x in range(w*2)] for y in range(h*2)] 

    array_cntx = 0
    array_cnty = 0
    for i in range(image.height):
        for x in range(2):
            for j in range(image.width):
                for k in range(2):
                    new_array[array_cnty][array_cntx] = img_array[i][j]
                    array_cntx += 1
            array_cnty += 1
            array_cntx = 0

    new_img = Image.fromarray(np.array(new_array))

    return new_img
    
            

image = read_image(image_path)
new_image = (double_image(image))
#new_image = double_image(new_image)
#new_image = double_image(new_image)
new_image.show()
new_image.save('temp2.png')
