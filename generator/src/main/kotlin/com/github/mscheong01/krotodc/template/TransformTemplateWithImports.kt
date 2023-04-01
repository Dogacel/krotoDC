// Copyright 2023 Minsoo Cheong
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.github.mscheong01.krotodc.template

import com.github.mscheong01.krotodc.import.Import

/**
 * A data class that contains a [TransformTemplate] and a set of [Import] imports.
 * The imports set must contain all imports required to use the template.
 */
data class TransformTemplateWithImports(
    val template: TransformTemplate,
    val imports: Set<Import>
) {
    companion object {
        fun of(template: TransformTemplate, imports: Set<Import> = setOf()) =
            TransformTemplateWithImports(template, imports = imports)
        fun of(template: String, imports: Set<Import> = setOf()) =
            TransformTemplateWithImports(TransformTemplate(template), imports = imports)
    }
}
